package com.example.egym.topstories.presentation.top_stories_sections

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.coroutineScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.egym.R
import com.example.egym.databinding.FragmentTopStoriesSectionsBinding
import com.example.egym.topstories.util.Constants
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class TopStoriesSectionsFragment : Fragment() {

    @Inject
    lateinit var adapter: TopStoriesSectionsAdapter

    val viewModel: TopStoriesSectionsViewModel by viewModels()
    private val args: TopStoriesSectionsFragmentArgs by navArgs()
    private lateinit var binding: FragmentTopStoriesSectionsBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_top_stories_sections,
            container,
            false
        )
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        binding.rvTopStoriesSections.adapter = adapter

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getTopStoriesSections(args.id)
        lifecycle.coroutineScope.launchWhenCreated {
            viewModel.state.collect {

                if (it.isLoading) {
                    binding.tvTsSectionsNothingFound.visibility = View.GONE
                    binding.loaderTsSections.visibility = View.VISIBLE
                }
                if (it.error.isNotBlank()) {
                    binding.tvTsSectionsNothingFound.visibility = View.VISIBLE
                    binding.tvTsSectionsNothingFound.text = it.error
                    binding.loaderTsSections.visibility = View.GONE
                }

                it.topStoriesSections?.let {
                    setAppBarText(it.section)
                    if (it.results.isEmpty()) {
                        binding.tvTsSectionsNothingFound.visibility = View.VISIBLE
                    }
                    binding.tvTsSectionsNothingFound.visibility = View.GONE
                    binding.loaderTsSections.visibility = View.GONE
                    it.results?.let { data -> adapter.setContentList(data.toMutableList()) }
                }
            }
        }
        adapter.itemClickListener {
            if (it.byline == "") {
                Toast.makeText(requireContext(), Constants.DATA_IS_NOT_AVAILABLE, Toast.LENGTH_SHORT).show()
            } else {
                findNavController().navigate(
                    TopStoriesSectionsFragmentDirections.actionFragmentTopStoriesSectionsToFragmentTopStoriesSectionDetails(
                        it
                    )
                )
            }
        }
    }

    fun setAppBarText(text: String) {
        (requireActivity() as AppCompatActivity).supportActionBar?.title = text
    }
}
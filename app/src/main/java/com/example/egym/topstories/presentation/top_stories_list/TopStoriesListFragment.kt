package com.example.egym.topstories.presentation.top_stories_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.egym.R
import com.example.egym.databinding.FragmentTopStoriesBinding
import com.example.egym.topstories.data.data_source.dto.top_stories_dataset.DataSet
import com.example.egym.topstories.util.Constants
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class TopStoriesListFragment : Fragment() {

    @Inject
    lateinit var adapter: TopStoriesListAdapter

    private var _binding: FragmentTopStoriesBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_top_stories, container, false
        )
        binding.lifecycleOwner = viewLifecycleOwner
        binding.rvTopStories.adapter = adapter
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setAppBarText(Constants.APP_BAR_TEXT)
        val data = DataSet.createDataSet()
        adapter.submitList(data)
        adapter.clickListener.onItemClick = {
            setAppBarText(it.stories)
            findNavController().navigate(
                TopStoriesListFragmentDirections.actionFragmentTopStoriesToTopStoriesSections(
                    it.stories
                )
            )
        }
    }

    fun setAppBarText(text: String) {
        (requireActivity() as AppCompatActivity).supportActionBar?.title = text
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding.rvTopStories.adapter = null
    }
}
package com.example.egym.topstories.presentation.top_stories_section_details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.egym.R
import com.example.egym.databinding.FragmentTopStoriesSectionDetailsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TopStoriesSectionDetailsFragment : Fragment() {

    private val args: TopStoriesSectionDetailsFragmentArgs by navArgs()
    private lateinit var binding: FragmentTopStoriesSectionDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_top_stories_section_details,
            container,
            false
        )
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tvTsSectionDetailsNavBarTitle.text = args.resultParcelable.section
        binding.tvTsSectionDetailsAuthor.text = args.resultParcelable.byline
        binding.tvTsSectionDetailsDesc.text = args.resultParcelable.abstract
        binding.tvTsSectionDetailsTitle.text = args.resultParcelable.title
        Glide.with(this).load(args.resultParcelable.multimedia.get(1).url).into(binding.ivTsSectionDetailsImage)
        binding.tvTsSectionDetailsSeeMore.setOnClickListener{
            findNavController().navigate(TopStoriesSectionDetailsFragmentDirections.actionFragmentTopStoriesSectionDetailsToFragmentTopStoriesSectionDetailsWebview(args.resultParcelable.url))
        }
        setAppBarText(args.resultParcelable.section)
    }
    fun setAppBarText(text: String) {
        (requireActivity() as AppCompatActivity).supportActionBar?.title = text
    }
}
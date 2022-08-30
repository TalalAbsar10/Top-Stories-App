package com.example.egym.topstories.presentation.top_stories_section_details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.egym.R
import com.example.egym.databinding.FragmentTopStoriesSectionDetailsWebviewBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TopStoriesSectionDetailsWebViewFragment : Fragment() {

    private val args: TopStoriesSectionDetailsWebViewFragmentArgs by navArgs()
    private lateinit var binding: FragmentTopStoriesSectionDetailsWebviewBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_top_stories_section_details_webview,
            container,
            false
        )
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.webView.webViewClient = WebViewClient()
        binding.webView.loadUrl(args.id)
    }
}
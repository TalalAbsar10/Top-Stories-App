package com.example.egym.topstories.presentation.top_stories_sections

import com.example.egym.topstories.domain.model.TopStoriesDetails

data class TopStoriesSectionsState(
    val isLoading: Boolean = false,
    val topStoriesSections: TopStoriesDetails? = null,
    val error: String = ""
)
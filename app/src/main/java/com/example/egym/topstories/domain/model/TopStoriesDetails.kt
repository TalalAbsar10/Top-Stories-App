package com.example.egym.topstories.domain.model

import com.example.egym.topstories.data.data_source.dto.top_stories_details_dto.Result

data class TopStoriesDetails(
    val copyright: String,
    val lastUpdated: String,
    val numResults: Int,
    val results: List<Result>,
    val section: String,
    val status: String
)
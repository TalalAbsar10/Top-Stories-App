package com.example.egym.topstories.domain.model

import com.example.egym.topstories.data.data_source.dto.top_stories_details_dto.Result

data class TopStoriesSections(
    val section: String,
    val results: List<Result>
) {
}
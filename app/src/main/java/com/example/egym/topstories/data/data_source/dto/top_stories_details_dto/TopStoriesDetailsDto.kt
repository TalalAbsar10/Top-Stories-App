package com.example.egym.topstories.data.data_source.dto.top_stories_details_dto

import com.example.egym.topstories.data.data_source.database.TopStoriesDetailsEntity
import com.example.egym.topstories.domain.model.TopStoriesSections
import com.google.gson.annotations.SerializedName

data class TopStoriesDetailsDto(
    val copyright: String,
    @SerializedName("last_updated")
    val lastUpdated: String,
    @SerializedName("num_results")
    val numResults: Int,
    val results: List<Result>,
    val section: String,
    val status: String
) {
    fun toTopStoriesDetails(): TopStoriesDetailsEntity {
        return TopStoriesDetailsEntity(
            copyright = copyright,
            lastUpdated = lastUpdated,
            numResults = numResults,
            results = results,
            section = section,
            status = status
        )
    }
}

fun TopStoriesDetailsDto.toTopStoriesSections(): TopStoriesSections {
    return TopStoriesSections(
        section = section,
        results = results
    )
}



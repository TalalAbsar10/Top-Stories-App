package com.example.egym.topstories.data.data_source.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.example.egym.topstories.data.data_source.dto.top_stories_details_dto.Result
import com.example.egym.topstories.domain.model.TopStoriesDetails

@Entity(tableName = "topstoriesdb",indices = [Index(value = ["lastUpdated"], unique = true)])
data class TopStoriesDetailsEntity(
    val copyright: String,
    @ColumnInfo(name="lastUpdated")
    val lastUpdated: String,
    val numResults: Int,
    val results: List<Result>,
    val section: String,
    val status: String,
    @PrimaryKey val id: Int? = null
) {

    fun toTopStoriesDetails(): TopStoriesDetails{
        return TopStoriesDetails(
            copyright = copyright,
            lastUpdated = lastUpdated,
            numResults = numResults,
            results = results,
            section = section,
            status = status
        )
    }
}
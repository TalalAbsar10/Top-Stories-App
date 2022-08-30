package com.example.egym.topstories.data.data_source

import com.example.egym.topstories.data.data_source.dto.top_stories_details_dto.TopStoriesDetailsDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TopStoriesApi {

    @GET("v2/{section}.json")
    suspend fun getTopStoriesDetails(@Path("section") section: String, @Query("api-key") key:String): TopStoriesDetailsDto
}
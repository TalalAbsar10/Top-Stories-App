package com.example.egym.topstories.domain.repository

import com.example.egym.topstories.domain.model.TopStoriesDetails
import com.example.egym.topstories.util.Resource
import kotlinx.coroutines.flow.Flow

interface TopStoriesDetailsRepository {

     fun getTopStoriesDetails(section: String): Flow<Resource<TopStoriesDetails>>
}
package com.example.egym.topstories.domain.use_case.get_top_stories_sections

import com.example.egym.topstories.domain.model.TopStoriesDetails
import com.example.egym.topstories.domain.repository.TopStoriesDetailsRepository
import com.example.egym.topstories.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetTopStoriesSectionsUseCase @Inject constructor(
    private val repository: TopStoriesDetailsRepository
) {
    operator fun invoke(section: String): Flow<Resource<TopStoriesDetails>> {

        if (section.isBlank()) {
            return flow { }
        }
        return repository.getTopStoriesDetails(section)
    }
}
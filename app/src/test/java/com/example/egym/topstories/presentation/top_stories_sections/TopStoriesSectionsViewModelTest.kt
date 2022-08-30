package com.example.egym.topstories.presentation.top_stories_sections

import com.example.egym.topstories.domain.repository.TopStoriesDetailsRepository
import com.example.egym.topstories.domain.use_case.get_top_stories_sections.GetTopStoriesSectionsUseCase
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import org.junit.Before
import org.junit.Test

class TopStoriesSectionsViewModelTest {

    private lateinit var viewModel: TopStoriesSectionsViewModel
    private val getTopStoriesSectionsUseCase = mockk<GetTopStoriesSectionsUseCase>()
    private val repository = mockk<TopStoriesDetailsRepository>(relaxed = true)
    val _state = MutableStateFlow(TopStoriesSectionsState())
    val state: StateFlow<TopStoriesSectionsState> = _state

    @Before
    fun setUp() {
        viewModel = TopStoriesSectionsViewModel(getTopStoriesSectionsUseCase)
    }

    @Test
    fun getState() {
    }

    @Test
    suspend fun getTopStoriesSections() {
        getTopStoriesSectionsUseCase.invoke("food")
        state.collect {
            _state.value = TopStoriesSectionsState(true, it.topStoriesSections, "")
            coEvery { repository.getTopStoriesDetails("food") } returns mockk()
        }
    }
}

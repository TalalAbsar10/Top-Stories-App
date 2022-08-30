package com.example.egym.topstories.presentation.top_stories_sections

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.egym.topstories.domain.use_case.get_top_stories_sections.GetTopStoriesSectionsUseCase
import com.example.egym.topstories.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class TopStoriesSectionsViewModel @Inject constructor(
    private val getTopStoriesSectionsUseCase: GetTopStoriesSectionsUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(TopStoriesSectionsState())
    val state: StateFlow<TopStoriesSectionsState> = _state

    fun getTopStoriesSections(section: String) {
        getTopStoriesSectionsUseCase(section).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = TopStoriesSectionsState(topStoriesSections = result.data)
                }

                is Resource.Error -> {
                    _state.value = TopStoriesSectionsState(
                        error = result.message ?: "An unexpected error occurred"
                    )
                }

                is Resource.Loading -> {
                    _state.value = TopStoriesSectionsState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}
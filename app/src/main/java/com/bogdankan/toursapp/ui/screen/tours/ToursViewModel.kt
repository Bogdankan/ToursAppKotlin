package com.bogdankan.toursapp.ui.screen.tours

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bogdankan.toursapp.domain.model.Tour
import com.bogdankan.toursapp.domain.usecase.GetAllToursUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

sealed interface ToursState {
    object Loading : ToursState
    data class Data(val items: List<Tour>) : ToursState
    data class Error(val message: String) : ToursState
}

@HiltViewModel
class ToursViewModel @Inject constructor(
    private val getTours: GetAllToursUseCase
) : ViewModel() {

    private val _state = MutableStateFlow<ToursState>(ToursState.Loading)
    val state: StateFlow<ToursState> = _state

    init { refresh() }

    fun refresh() {
        _state.value = ToursState.Loading
        viewModelScope.launch {
            getTours().onSuccess {
                _state.value = ToursState.Data(it)
            }.onFailure { e ->
                _state.value = ToursState.Error(e.message ?: "Unknown error")
            }
        }
    }
}
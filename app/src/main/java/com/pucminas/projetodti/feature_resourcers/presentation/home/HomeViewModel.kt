package com.pucminas.projetodti.feature_resourcers.presentation.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pucminas.projetodti.feature_resourcers.domain.use_cases.DeleteResource
import com.pucminas.projetodti.feature_resourcers.domain.use_cases.GetResources
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val deleteResource: DeleteResource,
    getResources: GetResources
): ViewModel() {

    private val _state = mutableStateOf(HomeState())
    val state: State<HomeState> = _state

    init {
        getResources().onEach { resources ->
            _state.value = state.value.copy(
                resources = resources
            )
        }.launchIn(viewModelScope)
    }

    fun onEvent(event: HomeEvent) {
        when (event) {
            is HomeEvent.DeleteResource -> {
                viewModelScope.launch {
                    deleteResource(event.resource)
                }
            }
        }
    }
}
package com.pucminas.projetodti.feature_resourcers.presentation.edit

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pucminas.projetodti.feature_resourcers.domain.model.Resource
import com.pucminas.projetodti.feature_resourcers.domain.use_cases.GetResource
import com.pucminas.projetodti.feature_resourcers.domain.use_cases.InsertResource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EditViewModel @Inject constructor(
    private val getResource: GetResource,
    private val insertResource: InsertResource,
    savedStateHandle: SavedStateHandle
): ViewModel() {

    private val _resourceNameModel = mutableStateOf(TextFieldState())
    val resourceNameModel: State<TextFieldState> = _resourceNameModel

    private val _brand = mutableStateOf(TextFieldState())
    val brandModel: State<TextFieldState> = _brand

    private val _qnt = mutableStateOf(TextFieldState())
    val qntModel: State<TextFieldState> = _qnt

    private val _featureResource = mutableStateOf(TextFieldState())
    val featureResourceModel: State<TextFieldState> = _featureResource

    private val _obs = mutableStateOf(TextFieldState())
    val obsModel: State<TextFieldState> = _obs

    private val _eventFlow = MutableSharedFlow<UiEvent>()
    val eventFlow = _eventFlow.asSharedFlow()

    private var currentResourceId: Int? = null

    init {
        savedStateHandle.get<Int>("resourceId")?.let { resourceId ->
            if (resourceId != -1) {
                viewModelScope.launch {
                    getResource(resourceId)?.also { resource ->
                        currentResourceId = resource.id
                        _resourceNameModel.value = resourceNameModel.value.copy(
                            text = resource.resourceName
                        )
                        _brand.value = brandModel.value.copy(
                            text = resource.brand
                        )
                        _qnt.value = qntModel.value.copy(
                            text = resource.qnt.toString()
                        )
                        _featureResource.value = featureResourceModel.value.copy(
                            text = resource.featureResource
                        )
                        _obs.value = obsModel.value.copy(
                            text = resource.obs
                        )
                    }
                }
            }
        }
    }

    fun onEvent(event: EditEvent) {
       when (event) {
           is EditEvent.EnteredNameResource -> {
               _resourceNameModel.value = resourceNameModel.value.copy(
                   text = event.value
               )
           }
           is EditEvent.EnteredBrand -> {
               _brand.value = brandModel.value.copy(
                   text = event.value
               )
           }
           is EditEvent.EnteredQnt -> {
               _qnt.value = qntModel.value.copy(
                   text = event.value
               )
           }
           is EditEvent.EnteredFeatureResource -> {
               _featureResource.value = featureResourceModel.value.copy(
                   text = event.value
               )
           }
           is EditEvent.EnteredObs -> {
               _obs.value = obsModel.value.copy(
                   text = event.value
               )
           }
           EditEvent.InsertResource -> {
               viewModelScope.launch {
                   insertResource(
                       Resource(
                           resourceName = resourceNameModel.value.text,
                           brand = brandModel.value.text,
                           qnt = qntModel.value.text.toInt(),
                           featureResource = featureResourceModel.value.text,
                           obs = obsModel.value.text,
                           id = currentResourceId
                       )
                   )
                   _eventFlow.emit(UiEvent.SaveResource)
               }
           }
       }
    }

    sealed class UiEvent {
        object SaveResource: UiEvent()
    }
}
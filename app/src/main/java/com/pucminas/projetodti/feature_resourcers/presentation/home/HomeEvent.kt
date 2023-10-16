package com.pucminas.projetodti.feature_resourcers.presentation.home

import com.pucminas.projetodti.feature_resourcers.domain.model.Resource

sealed class HomeEvent {
    data class DeleteResource(val resource: Resource): HomeEvent()
}

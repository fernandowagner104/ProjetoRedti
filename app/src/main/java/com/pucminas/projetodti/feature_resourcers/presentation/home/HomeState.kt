package com.pucminas.projetodti.feature_resourcers.presentation.home

import com.pucminas.projetodti.feature_resourcers.domain.model.Resource

data class HomeState(
    val resources: List<Resource> = emptyList()
)

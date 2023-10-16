package com.pucminas.projetodti.feature_resourcers.domain.use_cases

import com.pucminas.projetodti.feature_resourcers.domain.model.Resource
import com.pucminas.projetodti.feature_resourcers.domain.repository.ResourceRepository
import javax.inject.Inject

class InsertResource @Inject constructor(
    private val repository: ResourceRepository
) {
    suspend operator fun invoke(resource: Resource) {
        repository.insertResource(resource)
    }
}
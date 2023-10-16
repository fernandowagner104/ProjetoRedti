package com.pucminas.projetodti.feature_resourcers.domain.use_cases

import com.pucminas.projetodti.feature_resourcers.domain.model.Resource
import com.pucminas.projetodti.feature_resourcers.domain.repository.ResourceRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetResources @Inject constructor(
    private val repository: ResourceRepository
) {
    operator fun invoke(): Flow<List<Resource>> {
        return repository.getResource()
    }
}
package com.pucminas.projetodti.feature_resourcers.domain.use_cases

import com.pucminas.projetodti.feature_resourcers.domain.model.Resource
import com.pucminas.projetodti.feature_resourcers.domain.repository.ResourceRepository
import javax.inject.Inject

class GetResource @Inject constructor(
    private val repository: ResourceRepository
) {
    suspend operator fun invoke(id: Int): Resource? {
        return repository.getResourceById(id)
    }
}
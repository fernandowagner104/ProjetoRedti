package com.pucminas.projetodti.feature_resourcers.domain.repository

import com.pucminas.projetodti.feature_resourcers.domain.model.Resource
import kotlinx.coroutines.flow.Flow

interface ResourceRepository {
    fun getResource(): Flow<List<Resource>>

    suspend fun getResourceById(id: Int): Resource?

    suspend fun insertResource(resource: Resource)

    suspend fun deleteResource(resource: Resource)
}
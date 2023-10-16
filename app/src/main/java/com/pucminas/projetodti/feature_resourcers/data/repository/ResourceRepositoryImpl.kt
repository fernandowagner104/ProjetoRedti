package com.pucminas.projetodti.feature_resourcers.data.repository

import com.pucminas.projetodti.feature_resourcers.data.source.local.dao.ResourceDao
import com.pucminas.projetodti.feature_resourcers.domain.model.Resource
import com.pucminas.projetodti.feature_resourcers.domain.repository.ResourceRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ResourceRepositoryImpl @Inject constructor(
    private val dao: ResourceDao
): ResourceRepository {
    override fun getResource(): Flow<List<Resource>> {
        return dao.getResources()
    }

    override suspend fun getResourceById(id: Int): Resource? {
       return dao.getResourceById(id)
    }

    override suspend fun insertResource(resource: Resource) {
        dao.insertResource(resource)
    }

    override suspend fun deleteResource(resource: Resource) {
        dao.deleteResource(resource)
    }
}
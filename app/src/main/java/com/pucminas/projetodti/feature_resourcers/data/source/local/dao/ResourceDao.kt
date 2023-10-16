package com.pucminas.projetodti.feature_resourcers.data.source.local.dao

import androidx.room.*
import com.pucminas.projetodti.feature_resourcers.domain.model.Resource
import kotlinx.coroutines.flow.Flow

@Dao
interface ResourceDao {
    @Query("SELECT * FROM Resource")
    fun getResources(): Flow<List<Resource>>

    @Query("SELECT * FROM Resource WHERE id = :id")
    suspend fun getResourceById(id: Int): Resource?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertResource(resource: Resource)

    @Delete
    suspend fun deleteResource(resource: Resource)
}
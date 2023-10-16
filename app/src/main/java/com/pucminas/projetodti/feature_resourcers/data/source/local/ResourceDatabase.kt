package com.pucminas.projetodti.feature_resourcers.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.pucminas.projetodti.feature_resourcers.data.source.local.dao.ResourceDao
import com.pucminas.projetodti.feature_resourcers.domain.model.Resource

@Database(
    entities = [Resource::class],
    version = 2,
    exportSchema = false
)
abstract class ResourceDatabase: RoomDatabase() {
    abstract val resourceDao: ResourceDao
}
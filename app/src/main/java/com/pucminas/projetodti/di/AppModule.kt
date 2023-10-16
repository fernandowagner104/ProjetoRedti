package com.pucminas.projetodti.di

import android.app.Application
import androidx.room.Room
import com.pucminas.projetodti.feature_resourcers.data.repository.ResourceRepositoryImpl
import com.pucminas.projetodti.feature_resourcers.data.source.local.ResourceDatabase
import com.pucminas.projetodti.feature_resourcers.domain.repository.ResourceRepository
import com.pucminas.projetodti.utils.DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideUserDatabase(app: Application) = Room.databaseBuilder(
        app,
        ResourceDatabase::class.java,
        DATABASE_NAME
    ).fallbackToDestructiveMigration().build()

    @Provides
    @Singleton
    fun provideRepository(db: ResourceDatabase): ResourceRepository {
        return ResourceRepositoryImpl(db.resourceDao)
    }
}
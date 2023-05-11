package com.kaellah.acronym.feature.di

import com.kaellah.acronym.feature.data.AcronymsRepository
import com.kaellah.acronym.feature.data.AcronymsRepositoryImpl
import com.kaellah.acronym.feature.data.source.local.AcronymsCache
import com.kaellah.acronym.feature.data.source.local.AcronymsCacheImpl
import com.kaellah.acronym.screen.data.AcronymDefinitionMapper
import com.kaellah.acronym.screen.data.AcronymDefinitionMapperImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * The definition of initialization for objects
 *  that are available while the application is available
 */
@Suppress("unused")
@Module
@InstallIn(SingletonComponent::class)
interface BindsModule {

    @Singleton
    @Binds
    fun getAcronymsCache(
        impl: AcronymsCacheImpl
    ): AcronymsCache

    @Binds
    fun getAcronymsRepository(
        impl: AcronymsRepositoryImpl
    ): AcronymsRepository

    @Binds
    fun getAcronymDefinitionMapper(
        impl: AcronymDefinitionMapperImpl
    ): AcronymDefinitionMapper
}

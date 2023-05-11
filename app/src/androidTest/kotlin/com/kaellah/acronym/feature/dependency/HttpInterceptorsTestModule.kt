package com.kaellah.acronym.feature.dependency

import com.kaellah.acronym.feature.data.source.remote.AcronymsApiTestInterceptor
import com.kaellah.acronym.feature.di.DiConstant
import com.kaellah.acronym.feature.di.HttpInterceptorsModule
import dagger.Module
import dagger.Provides
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn
import okhttp3.Interceptor

/**
 * Defines test interceptors for HTTP requests
 */
@Module
@TestInstallIn(
    components = [SingletonComponent::class],
    replaces = [HttpInterceptorsModule::class],
)
class HttpInterceptorsTestModule {

    @DiConstant.HttpInterceptors
    @Provides
    fun getHttpInterceptors(): List<Interceptor> =
        listOf(AcronymsApiTestInterceptor())
}

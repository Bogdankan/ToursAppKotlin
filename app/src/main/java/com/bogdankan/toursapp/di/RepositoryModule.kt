package com.bogdankan.toursapp.di

import com.bogdankan.toursapp.data.repository.ToursRepositoryImpl
import com.bogdankan.toursapp.data.remote.api.ToursApi
import com.bogdankan.toursapp.domain.repo.ToursRepository
import com.bogdankan.toursapp.domain.usecase.GetAllToursUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides @Singleton
    fun provideToursRepository(api: ToursApi): ToursRepository =
        ToursRepositoryImpl(api)

    @Provides @Singleton
    fun provideGetToursUseCase(repo: ToursRepository) =
        GetAllToursUseCase(repo)
}
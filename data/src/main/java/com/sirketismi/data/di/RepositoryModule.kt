package com.sirketismi.data.di

import com.sirketismi.data.HotelRepository
import com.sirketismi.data.HotelRepositoryInterface
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun providerSearchRepository(repository: HotelRepository): HotelRepositoryInterface
}
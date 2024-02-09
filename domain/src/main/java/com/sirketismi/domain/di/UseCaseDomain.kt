package com.sirketismi.domain.di

import com.sirketismi.data.HotelRepositoryInterface
import com.sirketismi.domain.usecase.SearchListUseCase
import com.sirketismi.domain.mapper.Json4Kotlin_BaseToUIStateMapper
import com.sirketismi.entities.model.Json4Kotlin_Base
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseDomain {

    @Provides
    @Singleton
    fun provideSearchUseCase(repositoryInterface: HotelRepositoryInterface, mapper : Json4Kotlin_BaseToUIStateMapper) = SearchListUseCase(repositoryInterface, mapper)
}
/*
fun method() : String {
    return ""
}
fun method2() : String = ""

val user : String
    get() {
        return ""
    }
val user : String get() = ""
 */
package com.sirketismi.domain.usecase

import com.sirketismi.common.flowstate.Resource
import com.sirketismi.data.HotelRepository
import com.sirketismi.data.HotelRepositoryInterface
import com.sirketismi.domain.mapper.Json4Kotlin_BaseToUIStateMapper
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class SearchListUseCase @Inject constructor(
    private val repository : HotelRepositoryInterface,
    private val mapper : Json4Kotlin_BaseToUIStateMapper
) {

    suspend fun getList() = flow {
        emit(Resource.Loading())
        repository.getHotels()?.result?.let {
            emit(Resource.Success(mapper.map(it)))
        } ?: emit(Resource.Error("Empty message error"))
    }.catch { exception ->
        emit(Resource.Error(exception.localizedMessage))
    }
}
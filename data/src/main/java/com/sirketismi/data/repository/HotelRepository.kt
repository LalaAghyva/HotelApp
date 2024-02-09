package com.sirketismi.data

import com.sirketismi.entities.model.Hotels
import com.sirketismi.entities.model.Json4Kotlin_Base
import com.sirketismi.network.ApiService
import javax.inject.Inject

interface HotelRepositoryInterface {

    suspend fun getHotels() : Json4Kotlin_Base?
}


class HotelRepository @Inject constructor(private val apiService: ApiService) : HotelRepositoryInterface {
    override suspend fun getHotels(): Json4Kotlin_Base? {
        return apiService.getHotels()
    }
}
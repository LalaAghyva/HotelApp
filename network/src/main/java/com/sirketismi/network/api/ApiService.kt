package com.sirketismi.network

import com.sirketismi.entities.model.Json4Kotlin_Base
import retrofit2.http.GET

interface ApiService {

    @GET("hotels")
    suspend fun getHotels() : Json4Kotlin_Base?
}
package com.josu64.horoscapp_am.data.network

import com.josu64.horoscapp_am.data.network.response.PredictionResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface HoroscopeApiService {
    @GET("/{sign}")
    suspend fun getHoroscope(@Path("sign") sign:String): PredictionResponse //Path name must match @GET name
    //This returns a PredictionResponseObject
}
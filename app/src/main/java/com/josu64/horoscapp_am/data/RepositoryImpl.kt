package com.josu64.horoscapp_am.data

import android.util.Log
import com.josu64.horoscapp_am.data.network.HoroscopeApiService
import com.josu64.horoscapp_am.data.network.response.PredictionResponse
import com.josu64.horoscapp_am.domain.Repository
import com.josu64.horoscapp_am.domain.model.PredictionModel
import javax.inject.Inject

class RepositoryImpl @Inject constructor(private val apiService: HoroscopeApiService) : Repository {

    //Get retrofit
    override suspend fun getPrediction(sign: String): PredictionModel? {
        //Get petition, in this case 'it' is the server response
        kotlin.runCatching { apiService.getHoroscope(sign) }
            .onSuccess { return it.toDomain() }
            .onFailure { Log.i("RepoImpl", "Error: ${it.message}") }
        //If call fails, return null
        return null
    }

}
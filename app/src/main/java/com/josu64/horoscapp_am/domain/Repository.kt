package com.josu64.horoscapp_am.domain

import com.josu64.horoscapp_am.data.network.response.PredictionResponse
import com.josu64.horoscapp_am.domain.model.PredictionModel

//Repository is a communication layer between the data and domain layers
//This interface defines what the model layer needs from the data layer
interface Repository {
    suspend fun getPrediction(sign: String): PredictionModel?
}
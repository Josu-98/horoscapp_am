package com.josu64.horoscapp_am.domain.usecase

import com.josu64.horoscapp_am.domain.Repository
import javax.inject.Inject

class GetPredictionUseCase @Inject constructor(private val repository: Repository){
    //Operator lets us override some call functions
    suspend operator fun invoke(sign: String) = repository.getPrediction(sign)
}
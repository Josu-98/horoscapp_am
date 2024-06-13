package com.josu64.horoscapp_am.data.network.response

import com.josu64.horoscapp_am.motherobject.HoroscopeMotherObject.anyResponse
import io.kotlintest.shouldBe
import org.junit.Test

class PredictionResponseTest {

    @Test
    fun `toDomain Returns Correct Prediction Model`(){
        //Given
        val predictionResponse = anyResponse.copy(sign = "libra")

        //When
        val predictionModel = predictionResponse.toDomain()

        //Then
        predictionModel.sign shouldBe  predictionResponse.sign
        predictionModel.horoscope shouldBe predictionResponse.horoscope

    }

}
package com.josu64.horoscapp_am.motherobject

import com.josu64.horoscapp_am.data.network.response.PredictionResponse
import com.josu64.horoscapp_am.domain.model.HoroscopeInfo

object HoroscopeMotherObject {

    val anyResponse = PredictionResponse("date", "prediction", "taurus")
    val horoscopeInfoList = listOf(
        HoroscopeInfo.Aries,
        HoroscopeInfo.Aquarius,
        HoroscopeInfo.Cancer,
        HoroscopeInfo.Capricorn,
        HoroscopeInfo.Scorpio,
        HoroscopeInfo.Gemini,
        HoroscopeInfo.Leo,
        HoroscopeInfo.Libra,
        HoroscopeInfo.Pisces,
        HoroscopeInfo.Sagittarius,
        HoroscopeInfo.Taurus,
        HoroscopeInfo.Virgo,
    )

}
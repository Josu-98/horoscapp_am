package com.josu64.horoscapp_am.data.providers

import com.josu64.horoscapp_am.domain.model.HoroscopeInfo
import com.josu64.horoscapp_am.domain.model.HoroscopeInfo.*
import javax.inject.Inject

//This is the layer which data to our view, in this case from the model

class HoroscopeProvider @Inject constructor() {
    fun getHoroscope(): List<HoroscopeInfo> {
        return listOf(
            Aries,
            Aquarius,
            Cancer,
            Capricorn,
            Scorpio,
            Gemini,
            Leo,
            Libra,
            Pisces,
            Sagittarius,
            Taurus,
            Virgo,
        )
    }
}
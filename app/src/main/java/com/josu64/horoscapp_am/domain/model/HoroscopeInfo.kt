package com.josu64.horoscapp_am.domain.model

import com.josu64.horoscapp_am.R

//We reference int values and not strings or anything else because this data will only store the assigned reference
//The view model will figure out how to transform said int references into images and strings later
sealed class HoroscopeInfo(val img: Int, val name: Int){

    data object Aries : HoroscopeInfo(R.drawable.aries, R.string.aries)
    data object Aquarius : HoroscopeInfo(R.drawable.aquario, R.string.aquarius)
    data object Cancer : HoroscopeInfo(R.drawable.cancer, R.string.cancer)
    data object Capricorn : HoroscopeInfo(R.drawable.capricornio, R.string.capricorn)
    data object Scorpio : HoroscopeInfo(R.drawable.escorpio, R.string.scorpio)
    data object Gemini : HoroscopeInfo(R.drawable.geminis, R.string.gemini)
    data object Leo : HoroscopeInfo(R.drawable.leo, R.string.leo)
    data object Libra : HoroscopeInfo(R.drawable.libra, R.string.libra)
    data object Pisces : HoroscopeInfo(R.drawable.piscis, R.string.pisces)
    data object Sagittarius : HoroscopeInfo(R.drawable.sagitario, R.string.sagittarius)
    data object Taurus : HoroscopeInfo(R.drawable.tauro, R.string.taurus)
    data object Virgo : HoroscopeInfo(R.drawable.virgo, R.string.virgo)

}
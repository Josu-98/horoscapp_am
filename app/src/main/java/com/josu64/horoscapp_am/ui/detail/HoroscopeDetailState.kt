package com.josu64.horoscapp_am.ui.detail

import com.josu64.horoscapp_am.domain.model.HoroscopeModel

//State manager class
sealed class HoroscopeDetailState {

    //This is an object because it does not have a
    data object Loading: HoroscopeDetailState()
    data class Error(val error: String): HoroscopeDetailState()
    data class Success(val prediction: String, val sign: String, val horoscopeModel: HoroscopeModel): HoroscopeDetailState()

}
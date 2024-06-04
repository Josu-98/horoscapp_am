package com.josu64.horoscapp_am.ui.horoscope

import androidx.lifecycle.ViewModel
import com.josu64.horoscapp_am.domain.model.HoroscopeInfo
import com.josu64.horoscapp_am.domain.model.HoroscopeInfo.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject


@HiltViewModel
class HoroscopeViewModel @Inject constructor() : ViewModel() {

    private var _horoscope = MutableStateFlow<List<HoroscopeInfo>>(emptyList())
    val horoscope: StateFlow<List<HoroscopeInfo>> = _horoscope

    //the init method is called when a viewModel is created
    init {
        _horoscope.value = listOf(
            Aries, Taurus, Gemini,
            Aries, Taurus, Gemini,
            Aries, Taurus, Gemini,
            Aries, Taurus, Gemini,
        )
    }
}
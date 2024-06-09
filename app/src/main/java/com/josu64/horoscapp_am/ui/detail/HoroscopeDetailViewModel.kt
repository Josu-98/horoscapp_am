package com.josu64.horoscapp_am.ui.detail

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class HoroscopeDetailViewModel @Inject constructor():ViewModel() {
    private var _state = MutableStateFlow<HoroscopeDetailState>(HoroscopeDetailState.Loading) //HoroscopeDetailState.Loading is the initial state
    val state: StateFlow<HoroscopeDetailState> = _state
}
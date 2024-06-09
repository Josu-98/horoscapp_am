package com.josu64.horoscapp_am.ui.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.josu64.horoscapp_am.domain.usecase.GetPredictionUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

//The view model comes here as an inject constructor argument
@HiltViewModel
class HoroscopeDetailViewModel @Inject constructor(private val getPredictionUseCase: GetPredictionUseCase):ViewModel() {
    private var _state = MutableStateFlow<HoroscopeDetailState>(HoroscopeDetailState.Loading) //HoroscopeDetailState.Loading is the initial state
    val state: StateFlow<HoroscopeDetailState> = _state

    fun getHoroscope(sign: String){
        //Without a dispatcher, this launches from the main thread
        viewModelScope.launch {
            _state.value = HoroscopeDetailState.Loading
            val result = withContext(Dispatchers.IO) {getPredictionUseCase(sign)}
            if (result != null){
                _state.value = HoroscopeDetailState.Success(result.horoscope, result.sign)
            } else {
                _state.value = HoroscopeDetailState.Error("Unknown error")
            }
        }
    }

}
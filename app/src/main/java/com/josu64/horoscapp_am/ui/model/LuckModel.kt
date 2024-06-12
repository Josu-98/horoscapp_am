package com.josu64.horoscapp_am.ui.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class LuckModel(
    //These annotations force the class to search for an int pointing to a resource reference
    @DrawableRes val image: Int,
    @StringRes val text: Int
)

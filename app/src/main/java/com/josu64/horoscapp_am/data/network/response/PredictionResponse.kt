package com.josu64.horoscapp_am.data.network.response

import com.google.gson.annotations.SerializedName

/*{
    "date": "2020-01-01",
    "horoscope": "Hoy será un día asqueroso para ti.",
    "icon": "https://newastro.vercel.app/static/assets/zodiac-1.png",
    "id": 10,
    "sign": "aries"
}*/

//Parameters must match the json keys
//In obfuscation, the parameter names might be changed, so to avoid breaking the api call we can use the tag @SerializedName
//If we place the required name inside of the tag, we can name the parameter as anything
data class PredictionResponse(
    @SerializedName("date") val date: String,
    @SerializedName("horoscope") val horoscope: String,
    @SerializedName("icon") val icon: String,

    //We can avoid the fields we won't use
)

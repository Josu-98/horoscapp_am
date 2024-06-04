package com.josu64.horoscapp_am.ui.horoscope.adapter

import android.view.View
import android.view.animation.LinearInterpolator
import androidx.recyclerview.widget.RecyclerView
import com.josu64.horoscapp_am.databinding.ItemHoroscopeBinding
import com.josu64.horoscapp_am.domain.model.HoroscopeInfo

//The list is initialized as empty
class HoroscopeViewHolder(view: View): RecyclerView.ViewHolder(view) {

    private val binding = ItemHoroscopeBinding.bind(view)

    fun render(horoscopeInfo: HoroscopeInfo, onItemSelected: (HoroscopeInfo) -> Unit){
        val context = binding.tvTitle.context
        binding.ivHoroscope.setImageResource(horoscopeInfo.img)
        binding.tvTitle.text = context.getString(horoscopeInfo.name)

        binding.clParent.setOnClickListener {
            startRotation(binding.ivHoroscope, onItemSelected = {onItemSelected(horoscopeInfo)}) //Lambdaception, passed so the onItemSelected function runs after animation has ended
        }
    }

    private fun startRotation(view: View, onItemSelected:() -> Unit){
        view.animate().apply {
            duration = 400
            interpolator = LinearInterpolator()
            rotationY(360F)
            withEndAction {
                onItemSelected()
            }
            start()
        }
    }

}
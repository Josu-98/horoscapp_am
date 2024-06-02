package com.josu64.horoscapp_am.ui.palmistry

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.josu64.horoscapp_am.R
import com.josu64.horoscapp_am.databinding.FragmentLuckBinding
import com.josu64.horoscapp_am.databinding.FragmentPalmistryBinding

//The best way to do this is configuring the parent 'Fragment' class so as to not have to configure fragments multiple times
class PalmistryFragment : Fragment() {

    private var _binding: FragmentPalmistryBinding? = null
    private val binding get() = _binding!! //Getter for binding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPalmistryBinding.inflate(layoutInflater, container, false)
        return binding.root
    }
}
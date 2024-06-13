package com.josu64.horoscapp_am.ui.palmistry

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.PermissionChecker
import com.josu64.horoscapp_am.Manifest
import com.josu64.horoscapp_am.R
import com.josu64.horoscapp_am.databinding.FragmentLuckBinding
import com.josu64.horoscapp_am.databinding.FragmentPalmistryBinding
import dagger.hilt.android.AndroidEntryPoint

//The best way to do this is configuring the parent 'Fragment' class so as to not have to configure fragments multiple times
@AndroidEntryPoint
class PalmistryFragment : Fragment() {

    companion object{
        private const val CAMERA_PERMISSION = android.Manifest.permission.CAMERA
    }

    private var _binding: FragmentPalmistryBinding? = null
    private val binding get() = _binding!! //Getter for binding

    private val requestPermissionLauncher = registerForActivityResult(ActivityResultContracts.RequestPermission()){ isGranted ->
        if (isGranted){
            //startCamera
        } else {
            Toast.makeText(requireContext(), "Please grant camera access to use this feature", Toast.LENGTH_LONG).show()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (checkCameraPermission()){

        } else {
            requestPermissionLauncher.launch(CAMERA_PERMISSION)
        }

    }

    private fun checkCameraPermission(): Boolean {
        return PermissionChecker.checkSelfPermission(requireContext(), CAMERA_PERMISSION) == PermissionChecker.PERMISSION_GRANTED
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPalmistryBinding.inflate(layoutInflater, container, false)
        return binding.root
    }
}
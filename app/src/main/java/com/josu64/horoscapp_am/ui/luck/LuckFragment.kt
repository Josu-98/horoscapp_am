package com.josu64.horoscapp_am.ui.luck

import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.view.animation.DecelerateInterpolator
import androidx.core.animation.doOnEnd
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.josu64.horoscapp_am.R
import com.josu64.horoscapp_am.databinding.FragmentLuckBinding
import com.josu64.horoscapp_am.ui.core.listeners.OnSwipeTouchListener
import com.josu64.horoscapp_am.ui.providers.RandomCardProvider
import dagger.hilt.android.AndroidEntryPoint
import java.util.Random
import javax.inject.Inject

@AndroidEntryPoint
class LuckFragment : Fragment() {

    private var _binding: FragmentLuckBinding? = null
    private val binding get() = _binding!! //Getter for binding

    @Inject
    lateinit var randomCardProvider: RandomCardProvider

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentLuckBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    private fun initUI() {
        preparePrediction()
        initListeners()
    }

    private fun preparePrediction() {
        val luck = randomCardProvider.getLuck()
        luck?.let {luck ->
            val prediction = getString(luck.text)

            binding.tvLuckDesc.text = prediction
            binding.ivLuckyCard.setImageResource(luck.image)
            binding.tvShareLuck.setOnClickListener { shareResult(prediction) }
        }
    }

    private fun shareResult(prediction: String) {
        val sendIntent: Intent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, prediction)
            type = "text/plain"
        }

        val shareIntent = Intent.createChooser(sendIntent, null)
        startActivity(shareIntent)

    }

    @SuppressLint("ClickableViewAccessibility")
    private fun initListeners() {
        binding.ivRoulette.setOnClickListener { spinRoulette() }
        /*binding.ivRoulette.setOnTouchListener{ object: OnSwipeTouchListener(requireContext()){
            override fun onSwipeRight() {
                spinRoulette()
            }

            override fun onSwipeLeft() {
                spinRoulette()
            }

        } }*/
    }

    private fun spinRoulette() {
        val random = Random()
        val degrees: Int = random.nextInt(1440) + 360

        val animator =
            ObjectAnimator.ofFloat(binding.ivRoulette, View.ROTATION, 0f, degrees.toFloat())
        animator.duration = 2000
        animator.interpolator = DecelerateInterpolator()
        animator.doOnEnd {
            slideCard()
        }
        animator.start()
    }

    private fun slideCard() {
        val slideUpAnimation = AnimationUtils.loadAnimation(requireContext(), R.anim.slide_up)
        slideUpAnimation.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation?) {
                binding.ivReverse.isVisible = true
            }

            override fun onAnimationEnd(animation: Animation?) {
                scaleCard()
            }

            override fun onAnimationRepeat(animation: Animation?) {}

        })

        binding.ivReverse.startAnimation(slideUpAnimation)
    }

    private fun scaleCard() {
        val scaleAnimation = AnimationUtils.loadAnimation(requireContext(), R.anim.scale)
        scaleAnimation.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation?) {}

            override fun onAnimationEnd(animation: Animation?) {
                //Screen transition
                binding.ivReverse.isVisible = false
                showPremonitionView()
            }

            override fun onAnimationRepeat(animation: Animation?) {}

        })

        binding.ivReverse.startAnimation(scaleAnimation)

    }

    private fun showPremonitionView() {
        val disappearAnimation = AlphaAnimation(1.0F, 0.0F)
        disappearAnimation.duration = 400

        val appearAnimation = AlphaAnimation(0.0F, 1.0F)
        appearAnimation.duration = 1200

        disappearAnimation.setAnimationListener(object : Animation.AnimationListener{
            override fun onAnimationStart(animation: Animation?) {}

            override fun onAnimationEnd(animation: Animation?) {
                binding.cvPreview.isVisible = false
                binding.cvPrediction.isVisible = true
            }

            override fun onAnimationRepeat(animation: Animation?) {}

        })

        binding.cvPreview.startAnimation(disappearAnimation)
        binding.cvPrediction.startAnimation(appearAnimation)

    }

}
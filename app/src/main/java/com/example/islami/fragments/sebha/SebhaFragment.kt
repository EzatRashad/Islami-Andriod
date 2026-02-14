package com.example.islami.fragments.sebha

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.RotateAnimation
import androidx.fragment.app.Fragment
import com.example.islami.databinding.FragmentSebhaBinding

class SebhaFragment : Fragment() {

    private lateinit var binding: FragmentSebhaBinding

    private var count = 0
    private var zekrIndex = 0

    private val azkarList = listOf(
        "سبحان الله",
        "الحمد لله",
        "الله أكبر"
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSebhaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        updateUI()
        setupClicks()
    }

    private fun setupClicks() {

        binding.sebhaCountBody.setOnClickListener {

            count++


            if (count > 33) {
                moveToNextZekr()
            }

            updateUI()
            rotateSebha()
        }

        binding.resetBtn.setOnClickListener {
            count = 0
            zekrIndex = 0
            updateUI()
        }
    }


    private fun updateUI() {
        binding.sebhaCountText.text = count.toString()
        binding.zekrText.text = azkarList[zekrIndex]
    }


    private fun moveToNextZekr() {

        count = 1

        zekrIndex++


        if (zekrIndex >= azkarList.size) {
            zekrIndex = 0
        }
    }


    private fun rotateSebha() {

        val rotate = RotateAnimation(
            0f,
            360f,
            RotateAnimation.RELATIVE_TO_SELF,
            0.5f,
            RotateAnimation.RELATIVE_TO_SELF,
            0.5f
        )

        rotate.duration = 300
        rotate.fillAfter = true

        binding.sebhaCountBody.startAnimation(rotate)
    }
}

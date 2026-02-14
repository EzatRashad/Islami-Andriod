package com.example.islami.fragments.sebha

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.islami.databinding.FragmentSebhaBinding

class SebhaFragment : Fragment() {

    private lateinit var binding: FragmentSebhaBinding

    private var count = 0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSebhaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        updateCounter()
        setupClicks()
    }

    private fun setupClicks() {

        binding.sebhaCount.setOnClickListener {
            count++
            updateCounter()
        }

        binding.resetBtn.setOnClickListener {
            count = 0
            updateCounter()
        }
    }

    private fun updateCounter() {
        binding.sebhaCount.text = count.toString()
    }
}

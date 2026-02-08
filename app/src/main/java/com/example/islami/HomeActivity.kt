package com.example.islami

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.islami.databinding.ActivityHomeBinding
import com.example.islami.fragments.HadethFragment
import com.example.islami.fragments.QuranFragment
import com.example.islami.fragments.RadioFragment
import com.example.islami.fragments.SebhaFragment

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        super.onCreate(savedInstanceState)

        binding.homeNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.quran_nav_item -> {pushFragment(QuranFragment())}
                R.id.hadeth_nav_item -> {pushFragment(HadethFragment())}
                R.id.tasbeh_nav_item -> {pushFragment(SebhaFragment())}
                R.id.radio_nav_item -> {pushFragment(RadioFragment())}
            }


            return@setOnItemSelectedListener true
        }
        binding.homeNav.selectedItemId=R.id.quran_nav_item
    }

    private fun pushFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(binding.homeFrame.id, fragment).commit()
    }
}
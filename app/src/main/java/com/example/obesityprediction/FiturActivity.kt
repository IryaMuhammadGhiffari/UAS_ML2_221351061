package com.example.obesityprediction

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.obesityprediction.databinding.ActivityFiturBinding

class FiturActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFiturBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFiturBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}
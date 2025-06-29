package com.example.obesityprediction

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.obesityprediction.databinding.ActivityTentangBinding

class TentangActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTentangBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTentangBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}
package com.example.obesityprediction

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.obesityprediction.databinding.ActivityModelBinding


class ModelActivity : AppCompatActivity() {

    private lateinit var binding: ActivityModelBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityModelBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }

}
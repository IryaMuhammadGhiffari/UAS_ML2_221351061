package com.example.obesityprediction

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.obesityprediction.databinding.ActivityMenuBinding

class MenuActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.buttonBack.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        binding.cardTentang.setOnClickListener {
            startActivity(Intent(this, TentangActivity::class.java))
        }

        binding.cardDataset.setOnClickListener {
            startActivity(Intent(this, DatasetActivity::class.java))
        }

        binding.cardFitur.setOnClickListener {
            startActivity(Intent(this, FiturActivity::class.java))
        }

        binding.cardModel.setOnClickListener {
            startActivity(Intent(this, ModelActivity::class.java))
        }

        binding.cardSimulasi.setOnClickListener {
            startActivity(Intent(this, PredictionActivity::class.java))
        }
    }
}

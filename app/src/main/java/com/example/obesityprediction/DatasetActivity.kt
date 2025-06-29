package com.example.obesityprediction

import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

@Suppress("DEPRECATION")
class DatasetActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dataset)


        val backButton: ImageButton = findViewById(R.id.button_back_dataset)
        backButton.setOnClickListener {
            onBackPressed()
        }


    }


}
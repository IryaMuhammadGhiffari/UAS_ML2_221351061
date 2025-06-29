package com.example.obesityprediction // Pastikan Anda mengganti ini dengan nama paket aplikasi Anda yang sebenarnya

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Button
import android.widget.ProgressBar // Import ProgressBar
import androidx.appcompat.app.AppCompatActivity

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {

    companion object {
        private const val INITIAL_SPLASH_DELAY: Long = 3000
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val progressBarLoading: ProgressBar? = findViewById(R.id.progressBar_loading)
        val enterAppButton: Button? = findViewById(R.id.button_enter_app)

        enterAppButton?.visibility = View.GONE

        progressBarLoading?.visibility = View.VISIBLE

        Handler(Looper.getMainLooper()).postDelayed({
            progressBarLoading?.visibility = View.GONE
            enterAppButton?.visibility = View.VISIBLE
        }, INITIAL_SPLASH_DELAY)

        enterAppButton?.setOnClickListener {
            val mainIntent = Intent(this@SplashActivity, MenuActivity::class.java)
            startActivity(mainIntent)
            finish()
        }
    }
}

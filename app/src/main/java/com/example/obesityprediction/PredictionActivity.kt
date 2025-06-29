package com.example.obesityprediction

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar

class PredictionActivity : AppCompatActivity() {

    private lateinit var editTextAge: EditText
    private lateinit var editTextWeight: EditText
    private lateinit var editTextHeight: EditText
    private lateinit var radioGroupGender: RadioGroup
    private lateinit var radioMale: RadioButton
    private lateinit var radioFemale: RadioButton
    private lateinit var btnPredict: Button
    private lateinit var resultTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_prediction)

        editTextAge = findViewById(R.id.editText_age)
        editTextWeight = findViewById(R.id.editText_weight)
        editTextHeight = findViewById(R.id.editText_height)
        radioGroupGender = findViewById(R.id.radioGroup_gender)
        radioMale = findViewById(R.id.radio_male)
        radioFemale = findViewById(R.id.radio_female)
        btnPredict = findViewById(R.id.btn_predict)
        resultTextView = findViewById(R.id.result_text_view)

        btnPredict.setOnClickListener {
            performPrediction()
        }
    }

    @SuppressLint("SetTextI18n", "DefaultLocale")
    private fun performPrediction() {
        val ageStr = editTextAge.text.toString()
        val weightStr = editTextWeight.text.toString()
        val heightStr = editTextHeight.text.toString()
        val selectedGenderId = radioGroupGender.checkedRadioButtonId
        if (ageStr.isEmpty() || weightStr.isEmpty() || heightStr.isEmpty()) {
            showSnackbar("Mohon lengkapi semua data.")
            return
        }

        if (selectedGenderId == -1) {
            showSnackbar("Mohon pilih jenis kelamin.")
            return
        }

        val age = ageStr.toIntOrNull()
        val weight = weightStr.toDoubleOrNull()
        val height = heightStr.toDoubleOrNull()

        if (age == null || weight == null || height == null || age <= 0 || weight <= 0 || height <= 0) {
            showSnackbar("Mohon masukkan angka yang valid dan positif.")
            return
        }

        val heightInMeters = height / 100.0
        val bmi = weight / (heightInMeters * heightInMeters)
        val predictionResult: String = when {
            bmi < 18.5 -> "Kekurangan Berat Badan"
            bmi >= 18.5 && bmi < 24.9 -> "Berat Badan Normal"
            bmi >= 25.0 && bmi < 29.9 -> "Kelebihan Berat Badan (Pre-Obesitas)"
            bmi >= 30.0 && bmi < 34.9 -> "Obesitas Tingkat I"
            bmi >= 35.0 && bmi < 39.9 -> "Obesitas Tingkat II"
            else -> "Obesitas Tingkat III (Morbid Obesitas)"
        }

        // 5. Menampilkan hasil prediksi
        resultTextView.text = "Hasil Prediksi: $predictionResult (BMI: ${String.format("%.2f", bmi)})"
    }

    private fun showSnackbar(message: String) {
        Snackbar.make(findViewById(android.R.id.content), message, Snackbar.LENGTH_SHORT).show()
    }
}

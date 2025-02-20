package com.example.paml1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.viewModels
import androidx.lifecycle.Observer

class MainActivity : AppCompatActivity() {
    // Deklarasi view components
    private lateinit var etLength: EditText
    private lateinit var etWidth: EditText
    private lateinit var etHeight: EditText
    private lateinit var tvResult: TextView

    // Inisialisasi ViewModel menggunakan delegation
    private val viewModel: VolumeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inisialisasi view dengan findViewById
        etLength = findViewById(R.id.etLength)
        etWidth = findViewById(R.id.etWidth)
        etHeight = findViewById(R.id.etHeight)
        tvResult = findViewById(R.id.tvResult)
        val btnCalculate: Button = findViewById(R.id.btnCalculate)

        // Set up observer untuk LiveData hasil volume
        viewModel.volumeResult.observe(this) { result ->
            tvResult.text = "Volume: $result"
        }

        // Set listener untuk tombol hitung
        btnCalculate.setOnClickListener {
            calculateVolume()
        }
    }

    private fun calculateVolume() {
        // Konversi input ke Double, default 0.0 jika invalid
        val length = etLength.text.toString().toDoubleOrNull() ?: 0.0
        val width = etWidth.text.toString().toDoubleOrNull() ?: 0.0
        val height = etHeight.text.toString().toDoubleOrNull() ?: 0.0

        // Panggil fungsi hitung di ViewModel
        viewModel.calculateVolume(length, width, height)
    }
}
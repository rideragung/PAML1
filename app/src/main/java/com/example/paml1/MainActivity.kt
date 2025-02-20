package com.example.paml1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.viewModels
import androidx.lifecycle.Observer

class MainActivity : AppCompatActivity() {
    private lateinit var etLength: EditText
    private lateinit var etWidth: EditText
    private lateinit var etHeight: EditText
    private lateinit var tvResult: TextView

    private val viewModel: VolumeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etLength = findViewById(R.id.etLength)
        etWidth = findViewById(R.id.etWidth)
        etHeight = findViewById(R.id.etHeight)
        tvResult = findViewById(R.id.tvResult)
        val btnCalculate: Button = findViewById(R.id.btnCalculate)

        // Set up observer untuk LiveData
        viewModel.volumeResult.observe(this) { result ->
            tvResult.text = "Volume: $result"
        }

        btnCalculate.setOnClickListener {
            calculateVolume()
        }
    }

    private fun calculateVolume() {
        val length = etLength.text.toString().toDoubleOrNull() ?: 0.0
        val width = etWidth.text.toString().toDoubleOrNull() ?: 0.0
        val height = etHeight.text.toString().toDoubleOrNull() ?: 0.0

        viewModel.calculateVolume(length, width, height)
    }
}
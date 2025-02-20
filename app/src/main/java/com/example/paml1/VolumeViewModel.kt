package com.example.paml1

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.math.roundToInt

class VolumeViewModel : ViewModel() {
    // MutableLiveData untuk menyimpan hasil volume (bisa diubah)
    private val _volumeResult = MutableLiveData<Int>()
    // LiveData publik yang hanya bisa dibaca
    val volumeResult: LiveData<Int> get() = _volumeResult

    fun calculateVolume(length: Double, width: Double, height: Double) {
        // Hitung volume dan bulatkan ke integer terdekat

        val result = (length * width * height).roundToInt()
        _volumeResult.value = result
    }
}
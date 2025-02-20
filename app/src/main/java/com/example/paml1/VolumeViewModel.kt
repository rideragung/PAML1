package com.example.paml1

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.math.roundToInt

class VolumeViewModel : ViewModel() {
    private val _volumeResult = MutableLiveData<Int>()
    val volumeResult: LiveData<Int> get() = _volumeResult

    fun calculateVolume(length: Double, width: Double, height: Double) {
        val result = (length * width * height).roundToInt()
        _volumeResult.value = result
    }
}
package com.example.hw4

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CountViewModel : ViewModel() {
    private val _counterData = MutableLiveData<Int>(0)
    val counterData: LiveData<Int> get() = _counterData

    private val _toastMessage = MutableLiveData<String>()
    val toastMessage: LiveData<String> get() = _toastMessage

    private val _textColor = MutableLiveData<Int>()
    val textColor: LiveData<Int> get() = _textColor

    private val _number = MutableLiveData<Int>()
    val number: LiveData<Int> = _number

    private val _showToast = MutableLiveData<Boolean>()
    val showToast: LiveData<Boolean> = _showToast

    init {
        _textColor.value = android.graphics.Color.BLACK
    }

    fun increment() {
        _counterData.value = (counterData.value ?: 0) + 1
        checkValues()
    }

    fun decrement() {
        _counterData.value = (_counterData.value ?: 0) - 1
        checkValues()
    }

    private fun checkValues() {
        _counterData.value.let {
            when (it) {
                10 -> _toastMessage.value = ("Поздравляем!")
                15 -> _textColor.value = android.graphics.Color.GREEN
                else -> {
                    _toastMessage.value = null
                    _textColor.value = android.graphics.Color.BLACK
                }
            }
        }
    }
}
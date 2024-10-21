package com.example.hw4



class CounterModel {

    private var count = 0

    fun increment() {
        count++
    }

    fun decrement() {
        count--
    }

    fun getCount() = count
}
package com.example.adventofcode2019.ui.main

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    val dataSet = IntArray(25) { i -> getStars(i + 1) }

    private fun getStars(day: Int) = when (day) {
        1 -> 2
        2 -> 2
        3 -> 2
        4 -> 2
        5 -> 2
        6 -> 1
        else -> 0
    }

}

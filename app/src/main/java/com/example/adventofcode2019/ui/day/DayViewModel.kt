package com.example.adventofcode2019.ui.day

import android.content.res.Resources
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.adventofcode2019.R
import com.example.adventofcode2019.solutions.*

class DayViewModel : ViewModel() {

    private val _updatePart1 = MutableLiveData<String>()
    val updatePart1: LiveData<String> = _updatePart1
    private val _updatePart2 = MutableLiveData<String>()
    val updatePart2: LiveData<String> = _updatePart2

    lateinit var solution: DaySolution
    lateinit var resources: Resources

    fun setSolution(day: Int?) {
        solution = when (day) {
            1 -> Day1()
            2 -> Day2()
            3 -> Day3()
            4 -> Day4()
            5 -> Day5()
            6 -> Day6()
            else -> Day0()
        }
    }
    fun onClickGetSolution(part: Part, input: String) {
        when (part) {
            Part.ONE -> {
                if (input.isEmpty()) _updatePart1.postValue(NO_INPUT)
                else _updatePart1.postValue(
                    resources.getString(
                        R.string.solution_text,
                        solution.part1Solution(input)
                    )
                )
            }
            Part.TWO -> {
                if (input.isEmpty()) _updatePart2.postValue(NO_INPUT)
                else _updatePart2.postValue(
                    resources.getString(
                        R.string.solution_text,
                        solution.part2Solution(input)
                    )
                )
            }
        }
    }

    companion object {
        const val NO_INPUT = "Please enter an input!"
    }

}

enum class Part {
    ONE,
    TWO
}
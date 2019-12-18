package com.example.adventofcode2019.solutions

import org.junit.Before
import org.junit.Test

import org.junit.Assert.*

class Day2Test {

    private lateinit var day2: Day2

    @Before
    fun setUp() {
        day2 = Day2()
        day2.is1202 = false
    }

    @Test
    fun part1Solution() {
        assertEquals(2, day2.part1Solution("1,0,0,0,99"))
        assertEquals(2, day2.part1Solution("2,3,0,3,99"))
        assertEquals(2, day2.part1Solution("2,4,4,5,99,0"))
        assertEquals(30, day2.part1Solution("1,1,1,4,99,5,6,0,99"))
    }

}
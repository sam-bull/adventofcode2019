package com.example.adventofcode2019.solutions

import org.junit.Before
import org.junit.Test

import org.junit.Assert.*

class Day1Test {

    private lateinit var day1: Day1

    @Before
    fun setUp() {
        day1 = Day1()
    }

    @Test
    fun part1Solution() {
        assertEquals(2, day1.part1Solution("12"))
        assertEquals(2, day1.part1Solution("14"))
        assertEquals(654, day1.part1Solution("1969"))
        assertEquals(33583, day1.part1Solution("100756"))
        assertEquals(658, day1.part1Solution("12\n14\n1969"))
    }

    @Test
    fun part2Solution() {
        assertEquals(2, day1.part2Solution("14"))
        assertEquals(966, day1.part2Solution("1969"))
        assertEquals(50346, day1.part2Solution("100756"))
    }
}
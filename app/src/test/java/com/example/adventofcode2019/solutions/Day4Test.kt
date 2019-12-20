package com.example.adventofcode2019.solutions

import org.junit.Before
import org.junit.Test

import org.junit.Assert.*

class Day4Test {

    private lateinit var day4: Day4

    @Before
    fun setUp() {
        day4 = Day4()
    }

    @Test
    fun part1Solution() {
        assertEquals(5, day4.part1Solution("123455-123499"))
        assertEquals(11, day4.part1Solution("123444-123499"))
        assertEquals(11, day4.part1Solution("123400-123499"))
        assertEquals(1, day4.part1Solution("987654-999999"))
        assertEquals(4, day4.part1Solution("654321-666670"))
        assertEquals(10, day4.part1Solution("654321-666700"))
        assertEquals(20, day4.part1Solution("654321-667000"))
        assertEquals(1231, day4.part1Solution("100000-200000"))
        assertEquals(2220, day4.part1Solution("123257-647015")) //!42 !51239 !51238 !586 !2100 !1764
    }

    @Test
    fun part2Solution() {
    }
}
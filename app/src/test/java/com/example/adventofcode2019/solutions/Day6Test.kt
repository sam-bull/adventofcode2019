package com.example.adventofcode2019.solutions

import org.junit.Before
import org.junit.Test

import org.junit.Assert.*

class Day6Test {

    private lateinit var day6: Day6

    @Before
    fun setUp() {
        day6 = Day6()
    }

    @Test
    fun part1Solution() {
        assertEquals(42, day6.part1Solution("COM)B\n" +
                "B)C\n" +
                "C)D\n" +
                "D)E\n" +
                "E)F\n" +
                "B)G\n" +
                "G)H\n" +
                "D)I\n" +
                "E)J\n" +
                "J)K\n" +
                "K)L"))
    }

    @Test
    fun part2Solution() {
        assertEquals(4, day6.part2Solution("COM)B\n" +
                "B)C\n" +
                "C)D\n" +
                "D)E\n" +
                "E)F\n" +
                "B)G\n" +
                "G)H\n" +
                "D)I\n" +
                "E)J\n" +
                "J)K\n" +
                "K)L\n" +
                "K)YOU\n" +
                "I)SAN"))
    }
}
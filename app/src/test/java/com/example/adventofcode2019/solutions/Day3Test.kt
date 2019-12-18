package com.example.adventofcode2019.solutions

import org.junit.Before
import org.junit.Test

import org.junit.Assert.*

class Day3Test {

    private lateinit var day3: Day3

    @Before
    fun setUp() {
        day3 = Day3()
    }

    @Test
    fun part1Solution() {
        assertEquals(6, day3.part1Solution("R8,U5,L5,D3\nU7,R6,D4,L4"))
        assertEquals(159, day3.part1Solution("R75,D30,R83,U83,L12,D49,R71,U7,L72\nU62,R66,U55,R34,D71,R55,D58,R83"))
        assertEquals(135, day3.part1Solution("R98,U47,R26,D63,R33,U87,L62,D20,R33,U53,R51\nU98,R91,D20,R16,D67,R40,U7,R15,U6,R7"))
    }

    @Test
    fun part2Solution() {
        assertEquals(30, day3.part2Solution("R8,U5,L5,D3\nU7,R6,D4,L4"))
        assertEquals(610, day3.part2Solution("R75,D30,R83,U83,L12,D49,R71,U7,L72\nU62,R66,U55,R34,D71,R55,D58,R83"))
        assertEquals(410, day3.part2Solution("R98,U47,R26,D63,R33,U87,L62,D20,R33,U53,R51\nU98,R91,D20,R16,D67,R40,U7,R15,U6,R7"))
    }
}
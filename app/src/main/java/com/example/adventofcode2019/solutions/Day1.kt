package com.example.adventofcode2019.solutions

class Day1 : DaySolution() {
    override fun part1Solution(input: String): Int {
        val lines = input.split("\n")
        var total = 0
        lines.forEach { total += (Integer.parseInt(it) / 3) - 2 }
        return total
    }

    override fun part2Solution(input: String): Int {
        return 0
    }

}
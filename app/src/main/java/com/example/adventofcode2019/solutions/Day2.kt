package com.example.adventofcode2019.solutions

class Day2 : DaySolution() {
    override fun part1Solution(input: String): Int {
        val intCodesStr = input.split(",")
        val intCodes = intCodesStr.map { Integer.parseInt(it) }.toMutableList()

        intCodes[1] = 12
        intCodes[2] = 2

        var i = 0
        loop@ while (true) {
            when (intCodes[i]) {
                1 -> intCodes[intCodes[i+3]] = intCodes[intCodes[i+1]] + intCodes[intCodes[i+2]]
                2 -> intCodes[intCodes[i+3]] = intCodes[intCodes[i+1]] * intCodes[intCodes[i+2]]
                99 -> break@loop
            }
            i += 4
        }
        return intCodes[0]
    }

    override fun part2Solution(input: String): Int {
        return 0
    }

}
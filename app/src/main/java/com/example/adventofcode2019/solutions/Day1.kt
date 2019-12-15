package com.example.adventofcode2019.solutions

class Day1 : DaySolution() {
    override fun part1Solution(input: String): Int {
        val lines = input.split("\n")
        var total = 0
        lines.forEach { total += calculateFuelForModule(Integer.parseInt(it)) }
        return total
    }

    override fun part2Solution(input: String): Int {
        val lines = input.split("\n")
        var total = 0
        lines.forEach {
            var mass = Integer.parseInt(it)
            var moduleTotal = 0
            while(true) {
                val fuelMass = calculateFuelForModule(mass)
                if (fuelMass > 0) {
                    moduleTotal += fuelMass
                    mass = fuelMass
                }
                else break
            }
            total += moduleTotal
        }
        return total
    }

    private fun calculateFuelForModule(mass: Int) = (mass / 3) - 2

}
package com.example.adventofcode2019.solutions

import kotlin.math.abs

class Day3 : DaySolution() {
    override fun part1Solution(input: String): Int {
        val lines = input.split("\n")
        val firstWire = lines[0].split(",")
        val secondWire = lines[1].split(",")

        val grid = Grid()

        grid.addWire(firstWire, Grid.Marker.ONE)
        grid.addWire(secondWire, Grid.Marker.TWO)

        return grid.shortest
    }


    override fun part2Solution(input: String): Int {
        val lines = input.split("\n")
        val firstWire = lines[0].split(",")
        val secondWire = lines[1].split(",")

        val grid = Grid()

        grid.addWire(firstWire, Grid.Marker.ONE)
        grid.addWire(secondWire, Grid.Marker.TWO)
        grid.addWire(firstWire, Grid.Marker.ONE)

        var shortest = grid.crosses.values.first()
        grid.crosses.values.forEach {
            if (it < shortest) shortest = it
        }
        return shortest
    }

}

class Grid {

    private val grid = HashMap<Pair<Int, Int>, Marker>()

    companion object {
        val port = Pair(0, 0)
    }

    private lateinit var currentEnd: Pair<Int, Int>

    var shortest = 0

    var crosses = HashMap<Pair<Int, Int>, Int>()

    init {
        grid[port] = Marker.START
    }

    fun addWire(wire: List<String>, marker: Marker) {
        currentEnd = port
        var distFromPort = 0
        wire.forEach {
            val direction = it[0]
            val distance = Integer.parseInt(it.substring(1))
            when (direction) {
                'U' -> {
                    for (i in 1..distance) {
                        distFromPort++
                        set(currentEnd.first, currentEnd.second + i, marker, distFromPort)
                    }
                    currentEnd = Pair(currentEnd.first, currentEnd.second + distance)
                }
                'D' -> {
                    for (i in 1..distance) {
                        distFromPort++
                        set(currentEnd.first, currentEnd.second - i, marker, distFromPort)
                    }
                    currentEnd = Pair(currentEnd.first, currentEnd.second - distance)
                }
                'L' -> {
                    for (i in 1..distance) {
                        distFromPort++
                        set(currentEnd.first - i, currentEnd.second, marker, distFromPort)
                    }
                    currentEnd = Pair(currentEnd.first - distance, currentEnd.second)
                }
                'R' -> {
                    for (i in 1..distance) {
                        distFromPort++
                        set(currentEnd.first + i, currentEnd.second, marker, distFromPort)
                    }
                    currentEnd = Pair(currentEnd.first + distance, currentEnd.second)
                }
            }
        }
    }

    fun set(x: Int, y: Int, marker: Marker, distFromPort: Int) {
        val coord = Pair(x, y)
        val currentMark = if (grid.containsKey(coord)) grid[coord] else Marker.NONE
        grid[coord] = when (currentMark) {
            Marker.START -> currentMark
            Marker.CROSS -> {
                crosses[coord] = distFromPort + (crosses[coord] ?: 0)
                currentMark
            }
            marker.opposite() -> {
                val manhattanDistance = manhattanDistance(coord, port)
                if (shortest == 0 || manhattanDistance < shortest) shortest = manhattanDistance
                crosses[coord] = distFromPort + (crosses[coord] ?: 0)
                Marker.CROSS
            }
            else -> marker
        }
    }

    fun get(x: Int, y: Int) = grid[Pair(x, y)]

    private fun manhattanDistance(a: Pair<Int, Int>, b: Pair<Int, Int>): Int {
        return abs(a.first - b.first) + abs(a.second - b.second)
    }

    enum class Marker {
        NONE,
        START,
        ONE,
        TWO,
        CROSS;

        fun opposite() = if (this == ONE) TWO else ONE
    }

}
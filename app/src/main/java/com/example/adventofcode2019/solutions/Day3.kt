package com.example.adventofcode2019.solutions

import kotlin.math.abs

class Day3 : DaySolution() {
    override fun part1Solution(input: String): Int {
        val lines = input.split("\n")
        val firstWire = lines[0].split(",")
        val secondWire = lines[1].split(",")

        val grid = Grid()

        firstWire.forEach {
            grid.add(it[0], Integer.parseInt(it.substring(1)), Grid.Marker.ONE)
        }

        grid.reset()

        secondWire.forEach {
            grid.add(it[0], Integer.parseInt(it.substring(1)), Grid.Marker.TWO)
        }

        return grid.shortest
    }


    override fun part2Solution(input: String): Int {
        return 0
    }

}

class Grid {

    private val grid = HashMap<Pair<Int, Int>, Marker>()

    companion object {
        val port = Pair(0, 0)
    }

    private var currentEnd = port

    var shortest = 0

    init {
        grid[port] = Marker.START
    }

    fun reset() {
        currentEnd = port
    }

    fun add(direction: Char, distance: Int, marker: Marker) {
        when (direction) {
            'U' -> {
                for (i in 1..distance) {
                    set(currentEnd.first, currentEnd.second + i, marker)
                }
                currentEnd = Pair(currentEnd.first, currentEnd.second + distance)
            }
            'D' -> {
                for (i in 1..distance) {
                    set(currentEnd.first, currentEnd.second - i, marker)
                }
                currentEnd = Pair(currentEnd.first, currentEnd.second - distance)
            }
            'L' -> {
                for (i in 1..distance) {
                    set(currentEnd.first - i, currentEnd.second, marker)
                }
                currentEnd = Pair(currentEnd.first - distance, currentEnd.second)
            }
            'R' -> {
                for (i in 1..distance) {
                    set(currentEnd.first + i, currentEnd.second, marker)
                }
                currentEnd = Pair(currentEnd.first + distance, currentEnd.second)
            }
        }
    }

    fun set(x: Int, y: Int, marker: Marker) {
        val coord = Pair(x, y)
        val currentMark = if (grid.containsKey(coord)) grid[coord] else Marker.NONE
        grid[coord] = when (currentMark) {
            Marker.START, Marker.CROSS -> currentMark
            marker.opposite() -> {
                val manhattanDistance = manhattanDistance(coord, port)
                if (shortest == 0 || manhattanDistance < shortest) shortest = manhattanDistance
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
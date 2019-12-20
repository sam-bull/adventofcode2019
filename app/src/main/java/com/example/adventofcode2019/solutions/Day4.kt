package com.example.adventofcode2019.solutions

class Day4 : DaySolution() {
    override fun part1Solution(input: String): Int {
        val range = input.split("-")
        val lowerInt = Integer.parseInt(range[0])
        val upperInt = Integer.parseInt(range[1])

        var doubles = 0

        loopA@ for (a in 0..9) {
            loopB@ for (b in 0..9) {
                if (a > b) continue@loopB
                loopC@ for (c in 0..9) {
                    if (b > c) continue@loopC
                    loopD@ for (d in 0..9) {
                        if (c > d) continue@loopD
                        loopE@ for (e in 0..9) {
                            if (d > e) continue@loopE
                            loopF@ for (f in 0..9) {
                                if (e > f) continue@loopF
                                val str = listOf(a, b, c, d, e, f).joinToString("")
                                if (Integer.parseInt(str) in lowerInt..upperInt && (a == b ||
                                    b == c || c == d || d == e || e == f)) {
                                    doubles++
                                }
                            }
                        }
                    }
                }
            }
        }
        return doubles
    }

    override fun part2Solution(input: String): Int {
        return 0
    }

}
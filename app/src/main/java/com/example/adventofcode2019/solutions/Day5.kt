package com.example.adventofcode2019.solutions

class Day5 : DaySolution() {

    override fun part1Solution(input: String): Int {
        val intCodesStr = input.split(",")
        val intCodes = intCodesStr.map { Integer.parseInt(it) }.toMutableList()

        return run(intCodes)
    }

    override fun part2Solution(input: String): Int {
        val intCodesStr = input.split(",")
        val intCodes = intCodesStr.map { Integer.parseInt(it) }.toMutableList()

        return run(intCodes, 5)
    }

    private fun run(intCodes: MutableList<Int>, input: Int = 1): Int {
        var output = -1
        var i = 0
        loop@ while (true) {
            var opcodeStr = intCodes[i].toString()
            if (opcodeStr.length < 2) opcodeStr = "0$opcodeStr"
            val opcode = Integer.parseInt(opcodeStr.substring(opcodeStr.length - 2))
            val params = opcodeStr.substring(0, opcodeStr.length - 2).toCharArray()
                .map { Integer.parseInt(it.toString()) }.reversed().toMutableList()
            for (j in params.size..4) {
                params.add(0)
            }
            when (opcode) {
                1 -> {
                    val param1 = if (params[0] == 0) intCodes[intCodes[i + 1]] else intCodes[i + 1]
                    val param2 = if (params[1] == 0) intCodes[intCodes[i + 2]] else intCodes[i + 2]
                    intCodes[intCodes[i + 3]] = param1 + param2
                    i += 4
                }
                2 -> {
                    val param1 = if (params[0] == 0) intCodes[intCodes[i + 1]] else intCodes[i + 1]
                    val param2 = if (params[1] == 0) intCodes[intCodes[i + 2]] else intCodes[i + 2]
                    intCodes[intCodes[i + 3]] = param1 * param2
                    i += 4
                }
                3 -> {
                    intCodes[intCodes[i + 1]] = input
                    i += 2
                }
                4 -> {
                    val param1 = if (params[0] == 0) intCodes[intCodes[i + 1]] else intCodes[i + 1]
                    println(param1)
                    output = param1
                    i += 2
                }
                5 -> {
                    val param1 = if (params[0] == 0) intCodes[intCodes[i + 1]] else intCodes[i + 1]
                    val param2 = if (params[1] == 0) intCodes[intCodes[i + 2]] else intCodes[i + 2]
                    i = if (param1 != 0) param2 else i + 3
                }
                6 -> {
                    val param1 = if (params[0] == 0) intCodes[intCodes[i + 1]] else intCodes[i + 1]
                    val param2 = if (params[1] == 0) intCodes[intCodes[i + 2]] else intCodes[i + 2]
                    i = if (param1 == 0) param2 else i + 3
                }
                7 -> {
                    val param1 = if (params[0] == 0) intCodes[intCodes[i + 1]] else intCodes[i + 1]
                    val param2 = if (params[1] == 0) intCodes[intCodes[i + 2]] else intCodes[i + 2]
                    intCodes[intCodes[i + 3]] = if (param1 < param2) 1 else 0
                    i += 4
                }
                8 -> {
                    val param1 = if (params[0] == 0) intCodes[intCodes[i + 1]] else intCodes[i + 1]
                    val param2 = if (params[1] == 0) intCodes[intCodes[i + 2]] else intCodes[i + 2]
                    intCodes[intCodes[i + 3]] = if (param1 == param2) 1 else 0
                    i += 4
                }
                99 -> break@loop
                else -> throw IllegalArgumentException("opcode is $opcode")
            }
        }
        return output
    }
}
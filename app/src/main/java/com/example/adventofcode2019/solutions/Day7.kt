package com.example.adventofcode2019.solutions

class Day7 : DaySolution() {

    override fun part1Solution(input: String): Int {
        val intCodes = input.split(",").map { Integer.parseInt(it) }.toMutableList()

        val inputs = permute(listOf(0, 1, 2, 3, 4)).distinct()

        val outputs = mutableListOf<Int>()

        for (i in inputs.indices) {
            val aOutput = run(intCodes, inputs[i][0], 0)
            val bOutput = run(intCodes, inputs[i][1], aOutput)
            val cOutput = run(intCodes, inputs[i][2], bOutput)
            val dOutput = run(intCodes, inputs[i][3], cOutput)
            outputs.add(run(intCodes, inputs[i][4], dOutput))
        }

        return outputs.max() ?: -1
    }

    override fun part2Solution(input: String): Int {
        return 0
    }

   private fun <T> permute(list: List<T>): List<List<T>> {
        if (list.size == 1) return listOf(list)
        val perms = mutableListOf<List<T>>()
        val sub = list[0]
        for (perm in permute(list.drop(1)))
            for (i in 0..perm.size) {
                val newPerm = perm.toMutableList()
                newPerm.add(i, sub)
                perms.add(newPerm)
            }
        return perms
    }

    private fun run(intCodes: MutableList<Int>, input1: Int, input2: Int): Int {
        var output = -1
        var input1used = false
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
                    intCodes[intCodes[i + 1]] = if (!input1used) input1 else input2
                    input1used = !input1used
                    i += 2
                }
                4 -> {
                    val param1 = if (params[0] == 0) intCodes[intCodes[i + 1]] else intCodes[i + 1]
//                    println(param1)
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

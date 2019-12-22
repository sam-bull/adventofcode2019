package com.example.adventofcode2019.solutions

class Day6 : DaySolution() {

    override fun part1Solution(input: String): Int {
        //parent)child

        val orbitMap = HashMap<String, MutableList<String>>()
        input.split("\n").forEach {
            val planets = it.split(")")
            if (orbitMap.containsKey(planets[0])) orbitMap[planets[0]]?.add(planets[1])
            else orbitMap[planets[0]] = mutableListOf(planets[1])
        }
        val orbitTree = TreeNode("COM", 0)

        val populatedTree = populateTree(orbitTree, orbitMap)

        return orbitTree.getDepthSum()
    }

    override fun part2Solution(input: String): Int {
        return 0
    }

    private fun populateTree(tree: TreeNode<String>, map: Map<String, List<String>>) {
        map[tree.value]?.forEach { tree.addChild(it) }
        tree.children.forEach { populateTree(it, map) }
    }
}

class TreeNode<T>(val value: T, private val depth: Int) {

     val children = mutableListOf<TreeNode<T>>()

    fun addChild(child: T) {
         children.add(TreeNode(child, depth + 1))
    }

    fun getDepthSum(): Int =
        if (children.size == 0) {
            depth
        } else {
            var sum = 0
            children.forEach { sum += it.getDepthSum() }
            sum + depth
        }

}
package com.example.adventofcode2019.solutions

class Day6 : DaySolution() {

    private lateinit var santaOrbit: TreeNode<String>
    private lateinit var youOrbit: TreeNode<String>

    override fun part1Solution(input: String): Int {
        val orbitMap = HashMap<String, MutableList<String>>()
        input.split("\n").forEach {
            val planets = it.split(")")
            if (orbitMap.containsKey(planets[0])) orbitMap[planets[0]]?.add(planets[1])
            else orbitMap[planets[0]] = mutableListOf(planets[1])
        }
        val orbitTree = TreeNode("COM", 0)

        populateTree(orbitTree, orbitMap)

        return orbitTree.getDepthSum()
    }

    override fun part2Solution(input: String): Int {
        val orbitMap = HashMap<String, MutableList<String>>()
        input.split("\n").forEach {
            val planets = it.split(")")
            if (orbitMap.containsKey(planets[0])) orbitMap[planets[0]]?.add(planets[1])
            else orbitMap[planets[0]] = mutableListOf(planets[1])
        }
        val orbitTree = TreeNode("COM", 0)

        populateTree(orbitTree, orbitMap)

        val lca = lowestCommonAncestor(santaOrbit, youOrbit) ?: return -1

        return santaOrbit.depth - lca.depth + youOrbit.depth - lca.depth
    }

    private fun populateTree(tree: TreeNode<String>, map: Map<String, List<String>>) {
        map[tree.value]?.forEach { tree.addChild(it) }
        tree.children.forEach {
            if (it.value == "SAN") santaOrbit = tree
            if (it.value == "YOU") youOrbit = tree
            populateTree(it, map)
        }
    }

    private fun lowestCommonAncestor(a: TreeNode<String>, b: TreeNode<String>): TreeNode<String>? {
        val aAncestors = mutableListOf<String>()
        var node = a
        while (true) {
            val bAncestor = node.parent ?: break
            aAncestors.add(bAncestor.value)
            node = bAncestor
        }
        node = b
        while (true) {
            val bAncestor = node.parent ?: break
            if (aAncestors.contains(bAncestor.value)) return bAncestor
            node = bAncestor
        }
        return null
    }

}

class TreeNode<T>(val value: T, val depth: Int, val parent: TreeNode<T>? = null) {

    val children = mutableListOf<TreeNode<T>>()

    fun addChild(child: T) {
        children.add(TreeNode(child, depth + 1, this))
    }

    fun getDepthSum(): Int =
        if (children.size == 0) {
            depth
        } else {
            var sum = 0
            children.forEach { sum += it.getDepthSum() }
            sum + depth
        }

    override fun toString() = "{" +
            "$value " +
            "${children.map { it.value }}" +
            "}"
}

fun <T> MutableList<T>.pop(): T {
    val value = last()
    removeAt(size - 1)
    return value
}
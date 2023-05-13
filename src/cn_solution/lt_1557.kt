package cn_solution

fun findSmallestSetOfVertices(n: Int, edges: List<List<Int>>): List<Int> {
    val count = IntArray(n)
    edges.forEach { count[it[1]]++ }
    return (0 until n).filter { count[it] == 0 }
}

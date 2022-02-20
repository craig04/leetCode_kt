package cn_solution

fun findCenter(edges: Array<IntArray>): Int {
    return edges[0].let { if (it[0] in edges[1]) it[0] else it[1] }
}
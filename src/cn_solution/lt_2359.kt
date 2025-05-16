package cn_solution

fun closestMeetingNode(edges: IntArray, node1: Int, node2: Int): Int {
    fun traverse(node: Int): IntArray {
        val res = IntArray(edges.size) { Int.MAX_VALUE }
        var dis = 0
        var u = node
        while (u != -1 && res[u] == Int.MAX_VALUE) {
            res[u] = dis++
            u = edges[u]
        }
        return res
    }

    val x = traverse(node1)
    val y = traverse(node2)
    val ans = x.indices.minBy { maxOf(x[it], y[it]) }
    return if (maxOf(x[ans], y[ans]) == Int.MAX_VALUE) -1 else ans
}
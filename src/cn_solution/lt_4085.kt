package cn_solution

fun findColoredRoot(edges: Array<IntArray>, colors: String): Int {
    val n = colors.length
    val ins = IntArray(n)
    val outs = IntArray(n)
    val sons = mapOf('R' to 'B', 'B' to 'W', 'W' to 'R')
    for ((u, v) in edges) {
        if (colors[u] == colors[v])
            return -1
        else if (sons[colors[u]] == colors[v]) {
            if (++outs[u] > 2 || ++ins[v] > 1)
                return -1
        } else if (++outs[v] > 2 || ++ins[u] > 1)
            return -1
    }
    return ins.indexOfFirst { it == 0 }
}
package cn_solution

class Solution_913 {

    companion object {
        const val DRAW = -1
        const val MOUSE = 0
        const val CAT = 1
    }
    fun catMouseGame(graph: Array<IntArray>): Int {
        val n = graph.size
        val degree = Array(n) { Array(n) { IntArray(2) } }
        val result = Array(n) { Array(n) { IntArray(2) { DRAW } } }
        val q = ArrayDeque<IntArray>()
        for (i in 0 until n)
            for (j in 0 until n) {
                degree[i][j][MOUSE] = graph[i].size
                degree[i][j][CAT] = graph[j].size
            }
        for (node in graph[0])
            for (i in 0 until n)
                degree[i][node][CAT]--
        for (i in 1 until n) {
            result[0][i][CAT] = MOUSE
            q.addLast(intArrayOf(0, i, CAT))
            result[i][i][MOUSE] = CAT
            result[i][i][CAT] = CAT
            q.addLast(intArrayOf(i, i, MOUSE))
            q.addLast(intArrayOf(i, i, CAT))
        }
        while (q.isNotEmpty()) {
            val (x, y, z) = q.removeFirst()
            val res = result[x][y][z]
            val prev = ArrayList<IntArray>()
            if (z != MOUSE)
                graph[x].mapTo(prev) { intArrayOf(it, y, MOUSE) }
            else for (it in graph[y])
                if (it != 0)
                    prev.add(intArrayOf(x, it, CAT))
            for ((u, v, w) in prev) {
                if (result[u][v][w] == DRAW) {
                    if (res == w) {
                        result[u][v][w] = w
                        q.addLast(intArrayOf(u, v, w))
                    } else if (--degree[u][v][w] == 0) {
                        result[u][v][w] = 1 - w
                        q.addLast(intArrayOf(u, v, w))
                    }
                }
            }
        }
        return result[1][2][MOUSE] + 1
    }
}
package cn_solution

fun buildMatrix(k: Int, rowConditions: Array<IntArray>, colConditions: Array<IntArray>): Array<IntArray> {
    fun sort(conditions: Array<IntArray>): IntArray? {
        val order = IntArray(k + 1)
        val degree = IntArray(k + 1)
        val suffix = Array(k + 1) { ArrayList<Int>() }
        for ((u, v) in conditions) {
            suffix[u].add(v)
            degree[v]++
        }
        var idx = 0
        val q = (1..k).filterTo(ArrayDeque()) { degree[it] == 0 }
        while (q.isNotEmpty()) {
            val u = q.removeFirst()
            order[u] = idx++
            for (v in suffix[u])
                if (--degree[v] == 0)
                    q.addLast(v)
        }
        return if (idx == k) order else null
    }

    val row = sort(rowConditions)
    val col = sort(colConditions)
    if (row == null || col == null)
        return emptyArray()
    val matrix = Array(k) { IntArray(k) }
    for (i in 1..k)
        matrix[row[i]][col[i]] = i
    return matrix
}
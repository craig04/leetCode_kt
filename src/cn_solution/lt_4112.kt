package cn_solution

fun maxScore(parent: IntArray, op: IntArray, score: IntArray): Int {
    val n = parent.size
    val g = Array(n) { ArrayList<Int>() }
    for (i in 1 until n)
        g[parent[i]] += i
    fun dfs(x: Int): Int {
        var sum = score[x]
        if (g[x].isEmpty())
            return sum
        var min = Int.MAX_VALUE
        for (y in g[x]) {
            val sub = dfs(y)
            sum += sub
            min = minOf(min, sub)
        }
        if (op[x] == 1 || min < 0)
            sum -= min
        return sum
    }
    return dfs(0)
}
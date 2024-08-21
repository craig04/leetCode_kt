package cn_solution

fun countServers(n: Int, logs: Array<IntArray>, x: Int, queries: IntArray): IntArray {
    val sorted = Array(queries.size) { it }
    sorted.sortBy { queries[it] }
    logs.sortBy { it[1] }
    val num = IntArray(n + 1)
    var cnt = n
    var i = 0
    var j = 0
    val ans = IntArray(queries.size)
    for (idx in sorted) {
        val time = queries[idx]
        while (j != logs.size && logs[j][1] <= time)
            if (++num[logs[j++][0]] == 1)
                cnt--
        while (i != logs.size && logs[i][1] < time - x)
            if (--num[logs[i++][0]] == 0)
                cnt++
        ans[idx] = cnt
    }
    return ans
}
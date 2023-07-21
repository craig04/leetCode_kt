package cn_offer

fun movingCount(m: Int, n: Int, k: Int): Int {
    val rows = 0 until m
    val cols = 0 until n
    var count = 0
    val visit = Array(m) { BooleanArray(n) }
    val delta = intArrayOf(-1, 0, 0, -1, 0, 1, 1, 0)
    val digit = IntArray(100) { it / 10 + it % 10 }
    fun dfs(x: Int, y: Int) {
        count++
        visit[x][y] = true
        for (i in delta.indices step 2) {
            val p = x + delta[i]
            val q = y + delta[i + 1]
            if (p in rows && q in cols && !visit[p][q] && digit[p] + digit[q] <= k)
                dfs(p, q)
        }
    }
    dfs(0, 0)
    return count
}
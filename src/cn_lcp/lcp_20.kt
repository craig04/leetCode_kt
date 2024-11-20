package cn_lcp

fun busRapidTransit(target: Int, inc: Int, dec: Int, jump: IntArray, cost: IntArray): Int {
    val dest = target.toLong()
    val dp = hashMapOf(0L to 0L, 1L to inc.toLong())
    fun dfs(pos: Long): Long = dp.getOrPut(pos) {
        var ans = Long.MAX_VALUE
        for (i in jump.indices) {
            val x = pos / jump[i]
            val y = pos % jump[i]
            if (x != 0L) {
                val time = minOf(cost[i] + inc * y, (pos - x) * inc)
                ans = minOf(ans, dfs(x) + time)
            }
            if (y != 0L) {
                val time = minOf(cost[i] + dec * (jump[i] - y), (pos - x - 1) * inc)
                ans = minOf(ans, dfs(x + 1) + time)
            }
        }
        ans
    }
    return dfs(dest).mod(1000000007)
}
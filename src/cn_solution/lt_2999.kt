package cn_solution

fun numberOfPowerfulInt(start: Long, finish: Long, limit: Int, s: String): Long {
    val upper = finish.toString().toCharArray()
    val len = upper.size
    val str = start.toString()
    val lower = ("0".repeat(len - str.length) + str).toCharArray()
    val bigger = s >= String(lower, len - s.length, s.length)
    val smaller = s <= String(upper, len - s.length, s.length)
    val dp = LongArray(len) { -1 }
    fun dfs(i: Int, l: Boolean, r: Boolean): Long {
        if (i == len - s.length) {
            return if ((!l || bigger) && (!r || smaller)) 1 else 0
        }
        var result = dp[i]
        if (l || r || result == -1L) {
            val left = if (l) lower[i] else '0'
            val right = if (r) upper[i] else '9'
            result = (left..minOf(right, '0' + limit)).sumOf {
                dfs(i + 1, l && it == left, r && it == right)
            }
            if (!l && !r)
                dp[i] = result
        }
        return result
    }
    return dfs(0, l = true, r = true)
}
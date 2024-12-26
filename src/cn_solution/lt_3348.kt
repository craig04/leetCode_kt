package cn_solution

fun smallestNumber(num: String, t: Long): String {
    fun gcd(a: Long, b: Long): Long = if (b == 0L) a else gcd(b, a % b)
    var cnt = 0
    val factor = intArrayOf(2, 3, 5, 7).fold(t) { curr, i ->
        var next = curr
        while (next % i == 0L) {
            next /= i
            cnt++
        }
        next
    }
    if (factor != 1L)
        return "-1"
    val zero = maxOf(1, cnt - num.length)
    val len = num.length + zero
    val s = CharArray(len) { '0' }
    num.toCharArray(s, zero)
    val dp = Array(len) { HashSet<Long>() }
    val ans = CharArray(len) { '0' }
    fun dfs(i: Int, time: Long, limit: Boolean): Boolean {
        if (i == len)
            return time == 1L
        if (!limit && !dp[i].add(time))
            return false
        if (limit && i < zero && dfs(i + 1, time, true))
            return true
        val low = if (limit) maxOf(s[i], '1') else '1'
        for (d in low..'9') {
            ans[i] = d
            if (dfs(i + 1, time / gcd(time, d - '0' + 0L), limit && d == s[i]))
                return true
        }
        return false
    }
    dfs(0, t, true)
    val start = ans.indexOfFirst { it != '0' }
    return String(ans, start, len - start)
}
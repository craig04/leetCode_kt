package cn_solution

import kotlin.math.sign

fun countSpecialNumbers(n: Int): Int {
    val s = n.toString().toCharArray()
    val len = s.size
    val dp = HashMap<Int, Int>()
    fun dfs(i: Int, used: Int, limit: Int): Int {
        if (i == len)
            return 1
        return dp.getOrPut(used.shl(1).or(limit)) {
            val lower = 1 - used.sign
            val upper = if (limit == 1) s[i] - '0' else 9
            var count = 0
            for (t in lower..upper) {
                val next = 1.shl(t).or(used)
                if (next == used)
                    continue
                count += dfs(i + 1, next, (upper - t).sign.inv().and(limit))
            }
            count
        }
    }

    var cnt = 1
    return (1 until len).fold(dfs(0, 0, 1)) { acc, i ->
        cnt *= 11 - i
        acc + cnt / 10 * 9
    }
}
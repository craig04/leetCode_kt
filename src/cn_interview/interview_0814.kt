package cn_interview

fun countEval(s: String, result: Int): Int {
    val inf = Int.MIN_VALUE
    val subs = hashMapOf(
        '&' + 0 to intArrayOf(0, 0, 0, 1, 1, 0),
        '|' + 0 to intArrayOf(0, 0),
        '^' + 0 to intArrayOf(0, 0, 1, 1),
        '&' + 1 to intArrayOf(1, 1),
        '|' + 1 to intArrayOf(0, 1, 1, 0, 1, 1),
        '^' + 1 to intArrayOf(0, 1, 1, 0)
    )
    val position = s.length / 2 + 1
    val nums = IntArray(position) { s[it * 2] - '0' }
    val ops = CharArray(position - 1) { s[it * 2 + 1] }
    val dp = Array(position) { Array(position) { IntArray(2) { inf } } }
    nums.forEachIndexed { i, n ->
        dp[i][i][n] = 1
        dp[i][i][1 - n] = 0
    }
    fun dfs(l: Int, r: Int, res: Int): Int {
        if (dp[l][r][res] == inf) {
            dp[l][r][res] = (l until r).sumBy { i ->
                val sub = subs[ops[i] + res] ?: return@sumBy 0
                (sub.indices step 2).sumBy { j ->
                    dfs(l, i, sub[j]) * dfs(i + 1, r, sub[j + 1])
                }
            }
        }
        return dp[l][r][res]
    }
    return dfs(0, position - 1, result)
}
package cn_solution

fun count(num1: String, num2: String, min_sum: Int, max_sum: Int): Int {
    val mod = 1000000007
    val len = num2.length
    val str1 = num1.toCharArray(CharArray(len) { '0' }, len - num1.length)
    val str2 = num2.toCharArray()
    val bound = (len.shl(2) + 3) * max_sum + max_sum
    val dp = IntArray(bound + 1) { -1 }
    fun dfs(i: Int, lower: Boolean, upper: Boolean, sum: Int): Int {
        if (sum + (len - i) * 9 < min_sum || sum > max_sum)
            return 0
        if (i == len)
            return 1
        val key = (i.shl(2) + if (lower) 2 else 0 + if (upper) 1 else 0) * max_sum + sum
        if (dp[key] == -1) {
            val left = if (lower) str1[i] else '0'
            val right = if (upper) str2[i] else '9'
            dp[key] = (left..right).fold(0) { res, digit ->
                (res + dfs(
                    i + 1,
                    lower && digit == left,
                    upper && digit == right,
                    digit - '0' + sum
                )) % mod
            }
        }
        return dp[key]
    }
    return dfs(0, lower = true, upper = true, 0)
}
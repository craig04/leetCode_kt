package cn_solution

fun possibleStringCount(word: String, k: Int): Int {
    val modulo = 1000000007
    val n = word.length
    val nums = ArrayList<Int>()
    var length = k
    var x = 0
    var y = 0
    var total = 1L
    while (x != n) {
        while (y != n && word[y] == word[x])
            y++
        val len = y - x
        if (len == 1)
            length--
        else {
            nums.add(len)
            total = (total * len) % modulo
        }
        x = y
    }
    val m = nums.size
    if (m >= length)
        return total.toInt()
    val dp = Array(m + 1) { IntArray(length) }
    dp[0][0] = 1
    val pre = IntArray(length + 1)
    for (i in 1..m) {
        for (j in 0 until length)
            pre[j + 1] = (pre[j] + dp[i - 1][j]) % modulo
        for (j in i until length)
            dp[i][j] = (modulo + pre[j] - pre[maxOf(0, j - nums[i - 1])]) % modulo
    }
    return dp[nums.size].fold(total) { acc, cnt -> (acc + modulo - cnt) % modulo }.toInt()
}
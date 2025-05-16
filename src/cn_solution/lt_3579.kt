package cn_solution

fun minOperations(word1: String, word2: String): Int {
    val cnt = IntArray(26 * 26)
    fun steps(r1: IntProgression, r2: IntProgression): Int {
        val it1 = r1.iterator()
        val it2 = r2.iterator()
        var res = 0
        cnt.fill(0)
        while (it1.hasNext()) {
            val c1 = word1[it1.next()]
            val c2 = word2[it2.next()]
            if (c1 == c2)
                continue
            val x = (c1 - 'a') * 26 + (c2 - 'a')
            if (cnt[x] != 0) {
                cnt[x]--
                continue
            }
            val y = (c2 - 'a') * 26 + (c1 - 'a')
            cnt[y]++
            res++
        }
        return res
    }

    val n = word1.length
    val dp = IntArray(n + 1) { Int.MAX_VALUE }
    dp[n] = 0
    for (i in n - 1 downTo 0) {
        for (j in i until n) {
            dp[i] = minOf(
                dp[i],
                dp[j + 1] + steps(i..j, i..j),
                dp[j + 1] + steps(j downTo i, i..j) + 1
            )
        }
    }
    return dp[0]
}
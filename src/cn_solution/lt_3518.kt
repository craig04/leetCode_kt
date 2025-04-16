package cn_solution

fun smallestPalindrome(s: String, k: Int): String {
    val n = s.length
    val m = n / 2
    val cnt = IntArray(26)
    for (i in 0 until m)
        cnt[s[i] - 'a']++
    fun combination(n: Int, m: Int): Long {
        var res = 1L
        for (i in 0 until minOf(m, n - m)) {
            res = res * (n - i) / (i + 1)
            if (res > k)
                break
        }
        return res
    }

    fun permutation(): Long {
        var sum = cnt.sum()
        var res = 1L
        for (i in cnt.indices) {
            if (cnt[i] == 0)
                continue
            res *= combination(sum, cnt[i])
            if (res > k)
                break
            sum -= cnt[i]
        }
        return res
    }
    if (permutation() < k)
        return ""
    val ans = StringBuilder()
    var idx = k + 0L
    for (i in 0 until m) {
        for (j in cnt.indices) {
            if (cnt[j] == 0)
                continue
            cnt[j]--
            val p = permutation()
            if (p >= idx) {
                ans.append('a' + j)
                break
            }
            idx -= p
            cnt[j]++
        }
    }
    var i = ans.lastIndex
    if (n % 2 == 1)
        ans.append(s[m])
    while (i >= 0)
        ans.append(ans[i--])
    return ans.toString()
}
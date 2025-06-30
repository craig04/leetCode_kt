package cn_solution

fun sumScores(s: String): Long {
    val n = s.length
    val z = IntArray(n)
    var l = 0
    var r = 0
    return (1 until n).fold(0L + n) { ans, i ->
        if (i <= r)
            z[i] = minOf(z[i - l], r - i + 1)
        while (i + z[i] < n && s[i + z[i]] == s[z[i]])
            z[i]++
        if (i + z[i] - 1 > r) {
            l = i
            r = i + z[i] - 1
        }
        ans + z[i]
    }
}
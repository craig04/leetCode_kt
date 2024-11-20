package cn_solution

fun minimumScore(s: String, t: String): Int {
    val n = s.length
    val m = t.length
    val suf = IntArray(n + 1)
    suf[n] = m
    var j = m - 1
    for (i in n - 1 downTo 0) {
        if (s[i] == t[j])
            j--
        if (j < 0)
            return 0
        suf[i] = j + 1
    }
    j = 0
    return (0 until n).minOf { i ->
        if (j != m && s[i] == t[j])
            j++
        suf[i + 1] - j
    }.coerceIn(0, suf[0])
}
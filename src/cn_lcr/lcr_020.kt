package cn_lcr

fun countSubstrings(s: String): Int {
    val n = s.length
    val c = CharArray(2 * n + 1)
    for (i in s.indices) {
        c[2 * i] = '#'
        c[2 * i + 1] = s[i]
    }
    c[0] = '$'
    c[2 * n] = '@'
    var l = 0
    var r = 0
    val len = IntArray(2 * n + 1)
    return (1 until 2 * n).sumOf { i ->
        if (i <= r)
            len[i] = minOf(r - i, len[l + r - i])
        while (c[i + len[i]] == c[i - len[i]])
            len[i]++
        if (i + len[i] - 1 > r) {
            l = i - len[i] + 1
            r = i + len[i] - 1
        }
        (len[i] + i.and(1)) / 2
    }
}
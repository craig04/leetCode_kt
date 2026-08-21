package cn_solution

fun longestPalindrome(s: String): String {
    val n = s.length
    val a = CharArray(2 * n + 1) { '#' }
    for (i in 0 until n)
        a[i * 2 + 1] = s[i]
    var (l, r, c) = IntArray(3)
    val len = IntArray(2 * n + 1)
    for (i in 1 until 2 * n) {
        var h = 0
        if (i <= r)
            h = minOf(len[r - i + l], r - i)
        while (i in h + 1 until 2 * n - h && a[i - h - 1] == a[i + h + 1])
            h++
        if (i + h > r) {
            l = i - h
            r = i + h
        }
        if (h > len[c])
            c = i
        len[i] = h
    }
    return s.substring((c - len[c]) / 2, (c + len[c]) / 2)
}
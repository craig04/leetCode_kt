package cn_solution

fun longestCommonPrefix(words: Array<String>, k: Int): IntArray {
    val n = words.size
    if (n == k)
        return IntArray(n)
    val idx = Array(n) { it }
    idx.sortBy { words[it] }
    var (s, x, y) = IntArray(4)
    for (i in 0..n - k) {
        val a = words[idx[i]]
        val b = words[idx[i + k - 1]]
        var lcp = 0
        val len = minOf(a.length, b.length)
        while (lcp < len && a[lcp] == b[lcp])
            lcp++
        if (lcp > x) {
            y = x
            x = lcp
            s = i
        } else if (lcp > y)
            y = lcp
    }
    val ans = IntArray(n) { x }
    for (i in s until s + k)
        ans[idx[i]] = y
    return ans
}
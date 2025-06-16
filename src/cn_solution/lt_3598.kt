package cn_solution

private fun longestCommonPrefix(words: Array<String>): IntArray {
    fun commonPrefix(i: Int, j: Int): Int {
        val s = words[i]
        val t = words[j]
        val len = minOf(s.length, t.length)
        for (k in 0 until len)
            if (s[k] != t[k])
                return k
        return len
    }

    val n = words.size
    val len = IntArray(n - 1)
    val suf = IntArray(n + 1)
    for (i in n - 2 downTo 0) {
        len[i] = commonPrefix(i, i + 1)
        suf[i] = maxOf(len[i], suf[i + 1])
    }
    var pre = 0
    return IntArray(n) { i ->
        if (i >= 2)
            pre = maxOf(pre, len[i - 2])
        var add = 0
        if (i != 0 && i != n - 1)
            add = commonPrefix(i - 1, i + 1)
        maxOf(pre, suf[i + 1], add)
    }
}
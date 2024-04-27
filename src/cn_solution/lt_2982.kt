package cn_solution

private fun maximumLength(s: String): Int {
    val lens = Array(26) { intArrayOf(0, 0, 0) }
    fun add(c: Char, l: Int) {
        val len = lens[c - 'a']
        if (l > len[0]) {
            len[0] = l
            len[1] = len[0]
            len[2] = len[1]
        } else if (l > len[1]) {
            len[1] = l
            len[2] = len[1]
        } else if (l > len[2]) {
            len[2] = l
        }
    }

    var i = 0
    for (j in s.indices) {
        if (s[j] != s[i]) {
            add(s[i], j - i)
            i = j
        }
    }
    add(s[i], s.length - i)
    return lens.maxOf {
        val res = maxOf(it[2], minOf(it[0] - 1, it[1]), it[0] - 2)
        if (res <= 0) -1 else res
    }
}
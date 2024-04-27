package cn_solution

private fun maximumLength(s: String): Int {
    val len = Array(26) { ArrayList<Int>() }
    var i = 0
    for (j in s.indices) {
        if (s[j] != s[i]) {
            len[s[i] - 'a'].add(j - i)
            i = j
        }
    }
    len[s[i] - 'a'].add(s.length - i)
    return len.maxOf {
        it.sortDescending()
        var res = -1
        if (it.size >= 3)
            res = it[2]
        if (it.size >= 2 && it[0] > 1)
            res = maxOf(res, minOf(it[0] - 1, it[1]))
        if (it.size >= 1 && it[0] > 2)
            res = maxOf(res, it[0] - 2)
        res
    }
}
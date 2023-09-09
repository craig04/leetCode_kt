package cn_lcr

fun alienOrder(words: Array<String>): String {
    val alpha = BooleanArray(26)
    val degree = IntArray(26)
    val next = Array(26) { HashSet<Int>() }
    words[0].forEach { alpha[it - 'a'] = true }
    for (i in 1 until words.size) {
        val a = words[i - 1]
        val b = words[i]
        val len = minOf(a.length, b.length)
        var diff = false
        for (j in 0 until len) {
            if (!diff && a[j] != b[j]) {
                diff = true
                if (next[a[j] - 'a'].add(b[j] - 'a'))
                    degree[b[j] - 'a']++
            }
            alpha[b[j] - 'a'] = true
        }
        if (!diff && a.length > b.length)
            return ""
        (len until b.length).forEach { alpha[b[it] - 'a'] = true }
    }
    val sb = StringBuilder()
    val q = degree.indices.filterTo(ArrayDeque()) { alpha[it] && degree[it] == 0 }
    while (q.isNotEmpty()) {
        val c = q.removeFirst()
        sb.append('a' + c)
        next[c].forEach {
            if (--degree[it] == 0)
                q.addLast(it)
        }
    }
    return if (sb.length == alpha.count { it }) sb.toString() else ""
}
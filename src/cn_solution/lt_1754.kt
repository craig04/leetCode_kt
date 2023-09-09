package cn_solution

fun largestMerge(word1: String, word2: String): String {
    return buildString {
        val n = word1.length
        val m = word2.length
        val s = "$word1@$word2"
        val sa = Array(s.length) { it }
        val rk = IntArray(s.length * 2)
        val temp = IntArray(s.length)
        s.forEachIndexed { i, c -> rk[i] = c.code }
        var len = 1
        val times = maxOf(128, s.length + 1)
        while (len < s.length) {
            for (i in s.indices)
                temp[i] = rk[i] * times + rk[i + len]
            sa.sortBy { temp[it] }
            var r = 0
            var last = -1
            sa.forEach {
                if (temp[it] != last)
                    r++
                last = temp[it]
                rk[it] = r
            }
            if (r == s.length)
                break
            len *= 2
        }
        var i = 0
        var j = 0
        while (i != n && j != m) {
            if (rk[i] < rk[n + 1 + j])
                append(word2[j++])
            else
                append(word1[i++])
        }
        append(word1, i, n)
        append(word2, j, m)
    }
}
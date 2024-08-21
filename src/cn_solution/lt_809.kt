package cn_solution

fun expressiveWords(s: String, words: Array<String>): Int {
    return words.count { w ->
        var (i, j, x, y) = intArrayOf(0, 0, 0, 0)
        while (i != s.length && x != w.length) {
            if (s[i] != w[x])
                return@count false
            while (j != s.length && s[j] == s[i])
                j++
            while (y != w.length && w[y] == w[x])
                y++
            val m = j - i
            val n = y - x
            if (m < n || (m == 2 && n == 1))
                return@count false
            i = j
            x = y
        }
        i == s.length && x == w.length
    }
}
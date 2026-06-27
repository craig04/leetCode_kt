package cn_solution

fun minimumGroups(words: Array<String>): Int {
    fun minRepresentation(word: String): String {
        val n = word.length
        val s = word + word
        var i = 0
        var j = 1
        var k = 0
        while (maxOf(i, j, k) < n) {
            val x = s[i + k]
            val y = s[j + k]
            if (x == y) {
                k++
                continue
            }
            if (x < y)
                j += k + 1
            else
                i += k + 1
            if (i == j)
                j++
            k = 0
        }
        val pos = minOf(i, j)
        return s.substring(pos, pos + n)
    }

    val c = Array(2) { CharArray((words.maxOf { it.length } + 1) / 2) }
    return words.mapTo(HashSet()) { word ->
        for (i in word.indices)
            c[i % 2][i / 2] = word[i]
        val len = word.length
        val even = minRepresentation(String(c[0], 0, (len + 1) / 2))
        val odd = minRepresentation(String(c[1], 0, len / 2))
        even + odd
    }.size
}
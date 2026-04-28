package cn_solution

fun numSpecialEquivGroups(words: Array<String>): Int {
    return words.groupBy { word ->
        val c = Array(2) { CharArray((word.length + 1 - it) / 2) }
        for (i in word.indices)
            c[i % 2][i / 2] = word[i]
        c[0].sort()
        c[1].sort()
        "${String(c[0])}${String(c[1])}"
    }.size
}
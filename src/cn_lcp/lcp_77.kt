package cn_lcp

fun runeReserve(runes: IntArray): Int {
    runes.sort()
    var cnt = 1
    return (1 until runes.size).maxOfOrNull {
        if (runes[it] - runes[it - 1] > 1)
            cnt = 0
        ++cnt
    } ?: 1
}
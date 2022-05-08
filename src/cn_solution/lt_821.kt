package cn_solution

fun shortestToChar(s: String, c: Char): IntArray {
    val indices = arrayListOf(Int.MIN_VALUE)
    s.forEachIndexed { index, ch -> if (ch == c) indices.add(index) }
    indices.add(Int.MAX_VALUE)
    var pivot = 0
    return IntArray(s.length) {
        if (s[it] == c) pivot++
        minOf(it - indices[pivot], indices[pivot + 1] - it)
    }
}
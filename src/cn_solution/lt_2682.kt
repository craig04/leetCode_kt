package cn_solution

fun circularGameLosers(n: Int, k: Int): IntArray {
    val flag = BooleanArray(n)
    var pos = 0
    var gap = 0
    while (!flag[pos]) {
        flag[pos] = true
        gap += k
        pos = (pos + gap) % n
    }
    return flag.indices.asSequence()
        .filter { !flag[it] }
        .map { it + 1 }
        .toList()
        .toIntArray()
}
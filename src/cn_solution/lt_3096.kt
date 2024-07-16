package cn_solution

fun minimumLevels(possible: IntArray): Int {
    val score = IntArray(possible.size) { possible[it] * 2 - 1 }
    val total = score.sum()
    var alice = 0
    for (i in 0 until score.lastIndex) {
        alice += score[i]
        if (alice > total - alice)
            return i + 1
    }
    return -1
}
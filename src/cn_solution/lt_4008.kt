package cn_solution

fun minInitialStrength(monsters: IntArray, boosts: Array<IntArray>): Long {
    val n = monsters.size
    val bonus = LongArray(n + 1)
    for ((l, r, v) in boosts) {
        bonus[l] += v
        bonus[r + 1] -= v
    }
    for (i in 1 until bonus.size)
        bonus[i] += bonus[i - 1]
    return monsters.indices.reversed().fold(0L) { ans, i ->
        if (ans > 0)
            ans + monsters[i]
        else
            maxOf(monsters[i] - bonus[i], 0)
    }
}
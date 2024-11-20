package cn_solution

fun shiftDistance(s: String, t: String, nextCost: IntArray, previousCost: IntArray): Long {
    val next = Array(26) { LongArray(26) }
    val prev = Array(26) { LongArray(26) }
    for (i in 0 until 26) {
        var inc = 0L
        var dec = 0L
        for (j in 0 until 25) {
            inc += nextCost[(i + j) % 26]
            dec += previousCost[(i - j + 26) % 26]
            next[i][(i + j + 1) % 26] = inc
            prev[i][(i - j + 25) % 26] = dec
        }
    }
    val cost = Array(26) { i -> LongArray(26) { j -> minOf(next[i][j], prev[i][j]) } }
    return s.indices.sumOf { cost[s[it] - 'a'][t[it] - 'a'] }
}
package cn_solution

import kotlin.math.abs

fun equalSubstring(s: String, t: String, maxCost: Int): Int {
    var cost = 0
    var i = 0
    return s.indices.maxOf { j ->
        cost += abs(s[i] - t[i])
        while (cost > maxCost) {
            cost -= abs(s[i] - t[i])
            i++
        }
        j - i + 1
    }
}
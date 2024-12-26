package cn_solution

import kotlin.math.abs

fun countKeyChanges(s: String): Int {
    return (1 until s.length).count {
        val diff = abs(s[it] - s[it - 1])
        diff != 0 && diff != 32
    }
}
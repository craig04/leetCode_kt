package cn_solution

import kotlin.math.abs

fun isAdjacentDiffAtMostTwo(s: String): Boolean {
    return (1 until s.length).all { abs(s[it] - s[it - 1]) <= 2 }
}
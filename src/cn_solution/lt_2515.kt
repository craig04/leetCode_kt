package cn_solution

import kotlin.math.abs

fun closestTarget(words: Array<String>, target: String, startIndex: Int): Int {
    val n = words.size
    val ans = words.indices.minOf { i ->
        if (words[i] != target)
            return@minOf Int.MAX_VALUE
        val dist = abs(i - startIndex)
        minOf(dist, n - dist)
    }
    return if (ans == Int.MAX_VALUE) -1 else ans
}
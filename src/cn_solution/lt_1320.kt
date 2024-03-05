package cn_solution

import kotlin.math.abs

fun minimumDistance(word: String): Int {
    fun distance(a: Int, b: Int): Int {
        return abs(a / 6 - b / 6) + abs(a % 6 - b % 6)
    }

    val dp = HashMap<Int, Int>()
    fun dfs(pos: Int, a: Int, b: Int): Int {
        if (pos == word.length)
            return 0
        val key = (pos * 26 + a) * 26 + b
        return dp.getOrPut(key) {
            val c = word[pos] - 'A'
            minOf(
                dfs(pos + 1, c, b) + distance(a, c),
                dfs(pos + 1, a, c) + distance(b, c)
            )
        }
    }
    return (0 until 26).minOf { a ->
        (a until 26).minOf { b -> dfs(0, a, b) }
    }
}
package cn_solution

fun numEquivDominoPairs(dominoes: Array<IntArray>): Int {
    val map = HashMap<Int, Int>()
    return dominoes.sumOf { (a, b) ->
        val key = minOf(a, b) * 40001 + maxOf(a, b)
        (map.merge(key, 1, Int::plus) ?: 0) - 1
    }
}
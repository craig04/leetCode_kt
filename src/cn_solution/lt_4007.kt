package cn_solution

fun maximumWidth(planks: IntArray): Int {
    val cnt = planks.asSequence().groupingBy { it }.eachCount()
        .map { intArrayOf(it.key, it.value) }
    val map = HashMap<Int, Int>()
    cnt.forEachIndexed { i, (h1, c1) ->
        map.merge(h1, c1, Int::plus)
        map.merge(h1 * 2, c1 / 2, Int::plus)
        for (j in i + 1 until cnt.size) {
            val (h2, c2) = cnt[j]
            map.merge(h1 + h2, minOf(c1, c2), Int::plus)
        }
    }
    return map.values.max()
}
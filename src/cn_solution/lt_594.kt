package cn_solution

fun findLHS(nums: IntArray): Int {
    val map = HashMap<Int, Int>()
    for (n in nums) {
        map[n] = (map[n] ?: 0) + 1
    }
    return map.entries.fold(0) { ans, e ->
        maxOf(ans, map[e.key + 1]?.run { e.value + this } ?: 0)
    }
}
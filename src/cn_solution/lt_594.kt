package cn_solution

fun findLHS(nums: IntArray): Int {
    val map = HashMap<Int, Int>()
    for (num in nums)
        map.merge(num, 1, Int::plus)
    return map.maxOf { (k, v) -> map[k + 1]?.let { it + v } ?: 0 }
}
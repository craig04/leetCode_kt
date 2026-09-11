package cn_solution

fun maxEqualAdjacentPairs(nums: IntArray): Int {
    val map = HashMap<Long, Int>()
    var cnt = 0
    return (1 until nums.size).maxOf { i ->
        val x = nums[i - 1]
        val y = nums[i]
        if (x == y) {
            cnt++
            return@maxOf 0
        }
        val key = minOf(x, y) * 1000000001L + maxOf(x, y)
        map.merge(key, 1, Int::plus) ?: 0
    } + cnt
}
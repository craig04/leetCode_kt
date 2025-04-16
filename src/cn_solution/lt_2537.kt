package cn_solution

fun countGood(nums: IntArray, k: Int): Long {
    val map = HashMap<Int, Long>()
    var cnt = 0L
    var i = 0
    return nums.indices.sumOf { j ->
        cnt += (map.merge(nums[j], 1L, Long::plus) ?: 0) - 1
        while (cnt >= k)
            cnt -= map.merge(nums[i++], -1, Long::plus) ?: 0
        i + 0L
    }
}
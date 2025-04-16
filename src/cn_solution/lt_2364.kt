package cn_solution

fun countBadPairs(nums: IntArray): Long {
    val n = nums.size
    val map = HashMap<Int, Int>()
    return nums.indices.fold(n * (n - 1L) / 2) { ans, i ->
        ans - (map.merge(nums[i] - i, 1, Int::plus) ?: 0) + 1
    }
}
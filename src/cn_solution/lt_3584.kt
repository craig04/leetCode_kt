package cn_solution

fun maximumProduct(nums: IntArray, m: Int): Long {
    var min = Int.MAX_VALUE
    var max = Int.MIN_VALUE
    return (m - 1 until nums.size).maxOf {
        val pre = nums[it - m + 1]
        min = minOf(min, pre)
        max = maxOf(max, pre)
        val cur = nums[it]
        maxOf(1L * cur * min, 1L * cur * max)
    }
}
package cn_solution

fun searchInsert(nums: IntArray, target: Int): Int {
    var l = 0
    var r = nums.size
    while (l < r) {
        val m = (l + r) shr 1
        val n = nums[m]
        when {
            n > target -> r = m
            n < target -> l = m + 1
            else -> return m
        }
    }
    return l
}
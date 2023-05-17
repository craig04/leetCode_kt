package cn_solution

fun searchRange(nums: IntArray, target: Int): IntArray {
    var l = 0
    var r = nums.lastIndex
    while (l < r) {
        val m = (l + r) shr 1
        val num = nums[m]
        when {
            num < target -> l = m + 1
            num > target -> r = m - 1
            else -> r = m
        }
    }
    val begin = if (l == r && nums[l] == target) l else -1
    l = 0
    r = nums.lastIndex
    while (l < r) {
        val m = (l + r + 1) shr 1
        val num = nums[m]
        when {
            num < target -> l = m + 1
            num > target -> r = m - 1
            else -> l = m
        }
    }
    val end = if (l == r && nums[l] == target) l else -1
    return intArrayOf(begin, end)
}

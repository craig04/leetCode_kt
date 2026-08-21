package cn_solution

fun searchRange(nums: IntArray, target: Int): IntArray {
    fun ceiling(x: Int): Int {
        var l = 0
        var r = nums.size
        while (l < r) {
            val mid = (l + r) / 2
            if (nums[mid] >= x)
                r = mid
            else
                l = mid + 1
        }
        return l
    }

    val l = ceiling(target)
    return if (l == nums.size || nums[l] != target)
        intArrayOf(-1, -1)
    else
        intArrayOf(l, ceiling(target + 1) - 1)
}
package cn_solution

fun minMaxGame(nums: IntArray): Int {
    var len = nums.size
    while (len != 1) {
        len /= 2
        for (i in 0 until len) {
            val j = 2 * i
            when (i and 1) {
                0 -> nums[i] = minOf(nums[j], nums[j + 1])
                1 -> nums[i] = maxOf(nums[j], nums[j + 1])
            }
        }
    }
    return nums[0]
}

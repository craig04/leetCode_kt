package cn_solution

private fun minimumCost(nums: IntArray): Int {
    var x = Int.MAX_VALUE
    var y = Int.MAX_VALUE
    for (i in 1 until nums.size) {
        if (nums[i] < x) {
            y = x
            x = nums[i]
        } else if (nums[i] < y) {
            y = nums[i]
        }
    }
    return nums[0] + x + y
}
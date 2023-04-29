package cn_solution

private fun maxProduct(nums: IntArray): Int {
    var max = nums[0]
    var min = nums[0]
    var result = nums[0]
    for (i in 1 until nums.size) {
        val tmp = max
        max = maxOf(max * nums[i], min * nums[i], nums[i])
        min = minOf(tmp * nums[i], min * nums[i], nums[i])
        result = maxOf(result, max)
    }
    return result
}
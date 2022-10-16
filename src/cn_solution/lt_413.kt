package cn_solution

fun numberOfArithmeticSlices(nums: IntArray): Int {
    if (nums.size == 1)
        return 0
    var result = 0
    var count = 0
    var diff = nums[1] - nums[0]
    for (i in 2 until nums.size) {
        val temp = nums[i] - nums[i - 1]
        when (temp) {
            diff -> count++
            else -> count = 0
        }
        diff = temp
        result += count
    }
    return result
}

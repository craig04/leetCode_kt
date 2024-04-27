package cn_solution

private fun maxOperations(nums: IntArray): Int {
    val sum = nums[0] + nums[1]
    return ((3 until nums.size step 2).firstOrNull {
        nums[it - 1] + nums[it] != sum
    } ?: nums.size) shr 1
}
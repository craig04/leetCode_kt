package cn_solution

private fun minimumOperations(nums: IntArray): Int {
    return nums.count { it % 3 != 0 }
}
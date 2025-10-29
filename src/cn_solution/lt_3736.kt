package cn_solution

private fun minMoves(nums: IntArray): Int {
    return nums.max() * nums.size - nums.sum()
}
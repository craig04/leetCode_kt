package cn_solution

private fun maximizeSum(nums: IntArray, k: Int): Int {
    val n = nums.max()
    return (n + n + k - 1) * k / 2
}
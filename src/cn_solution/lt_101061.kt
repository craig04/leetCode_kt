package cn_solution

private fun concatWithReverse(nums: IntArray): IntArray {
    val n = nums.size
    val x = n * 2 - 1
    val ans = IntArray(n * 2)
    for (i in 0 until n) {
        ans[i] = nums[i]
        ans[x - i] = nums[i]
    }
    return ans
}
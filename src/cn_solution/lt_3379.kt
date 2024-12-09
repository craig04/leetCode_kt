package cn_solution

fun constructTransformedArray(nums: IntArray): IntArray {
    val n = nums.size
    return IntArray(n) { nums[(it + n + nums[it] % n) % n] }
}
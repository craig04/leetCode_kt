package cn_solution

fun shuffle(nums: IntArray, n: Int): IntArray {
    return IntArray(nums.size) { nums[it.shr(1) + it.and(1) * n] }
}

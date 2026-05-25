package cn_solution

fun xorBeauty(nums: IntArray): Int {
    return nums.reduce(Int::xor)
}
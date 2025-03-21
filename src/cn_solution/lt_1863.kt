package cn_solution

fun subsetXORSum(nums: IntArray): Int {
    return 1.shl(nums.lastIndex) * nums.reduce(Int::or)
}
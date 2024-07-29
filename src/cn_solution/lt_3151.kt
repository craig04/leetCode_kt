package cn_solution

fun isArraySpecial(nums: IntArray): Boolean {
    return (1 until nums.size).all { nums[it] xor nums[it - 1] and 1 == 1 }
}
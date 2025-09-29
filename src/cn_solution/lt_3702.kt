package cn_solution

import kotlin.math.sign

fun longestSubsequence(nums: IntArray): Int {
    var xor = 0
    var or = 0
    for (num in nums) {
        xor = xor xor num
        or = or or num
    }
    return if (or == 0) 0 else nums.size - 1 + xor.sign
}
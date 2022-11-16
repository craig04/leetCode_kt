package cn_solution

fun isIdealPermutation(nums: IntArray): Boolean {
    return nums.indices.all { Math.abs(it - nums[it]) <= 1 }
}

package cn_solution

fun minimumSwaps(nums: IntArray): Int {
    val cnt = nums.count { it == 0 }
    return (1..cnt).count { nums[nums.size - it] != 0 }
}
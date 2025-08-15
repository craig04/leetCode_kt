package cn_solution

fun sortPermutation(nums: IntArray): Int {
    return nums.indices.fold(-1) { res, i ->
        if (i != nums[i]) res and nums[i] else res
    }.coerceAtLeast(0)
}
package cn_solution

fun isMonotonic(nums: IntArray): Boolean {
    var inc = true
    var dec = true
    return (0 until nums.lastIndex).all {
        inc = inc.and(nums[it] <= nums[it + 1])
        dec = dec.and(nums[it] >= nums[it + 1])
        inc or dec
    }
}
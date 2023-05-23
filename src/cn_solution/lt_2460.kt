package cn_solution

fun applyOperations(nums: IntArray): IntArray {
    var p = 0
    val last = nums.lastIndex
    for (i in nums.indices) {
        if (i != last && nums[i] == nums[i + 1]) {
            nums[i] *= 2
            nums[i + 1] = 0
        }
        if (nums[i] != 0) {
            val tmp = nums[i]
            nums[i] = nums[p]
            nums[p++] = tmp
        }
    }
    return nums
}
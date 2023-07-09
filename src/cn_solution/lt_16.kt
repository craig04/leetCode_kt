package cn_solution

import kotlin.math.abs

fun threeSumClosest(nums: IntArray, target: Int): Int {
    nums.sort()
    var result = 1 shl 16
    var diff = result - target
    for (i in nums.indices) {
        if (i != 0 && nums[i] == nums[i - 1])
            continue
        var l = i + 1
        var r = nums.lastIndex
        while (l < r) {
            val sum = nums[i] + nums[l] + nums[r]
            if (sum == target)
                return target
            if (sum < target) l++ else r--
            val temp = abs(target - sum)
            if (temp < diff) {
                diff = temp
                result = sum
            }
        }
    }
    return result
}
package cn_solution

import kotlin.math.sign

fun minOperations(nums: IntArray): Int {
    var ans = 0
    var top = -1
    for (num in nums) {
        while (top != -1 && num < nums[top]) {
            top--
            ans++
        }
        if (top == -1 || num != nums[top])
            nums[++top] = num
    }
    return ans + top + nums[0].sign
}
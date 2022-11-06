package cn_solution

import java.util.*

private class Solution(val nums: IntArray) {

    private val n = nums.size

    fun reset(): IntArray {
        return nums
    }

    fun shuffle(): IntArray {
        val random = Random()
        val result = IntArray(n) { nums[it] }
        for (i in n downTo 1) {
            val t = random.nextInt(i)
            val temp = result[i - 1]
            result[i - 1] = result[t]
            result[t] = temp
        }
        return result
    }

}
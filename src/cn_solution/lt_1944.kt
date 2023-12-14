package cn_solution

import kotlin.math.sign

fun canSeePersonsCount(heights: IntArray): IntArray {
    val result = IntArray(heights.size)
    val stack = arrayListOf(Int.MAX_VALUE)
    for (i in heights.indices.reversed()) {
        val height = heights[i]
        while (height > stack.last()) {
            result[i]++
            stack.removeLast()
        }
        result[i] += (stack.size - 1).sign
        stack.add(height)
    }
    return result
}
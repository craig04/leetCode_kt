package cn_lcr

import java.util.*

fun largestRectangleArea(heights: IntArray): Int {
    var result = 0
    val n = heights.size
    val stack = Stack<Int>()
    val left = IntArray(n)
    heights.forEachIndexed { i, h ->
        while (stack.isNotEmpty() && heights[stack.peek()] >= h) {
            val t = stack.pop()
            result = maxOf(result, (i - left[t] - 1) * heights[t])
        }
        left[i] = if (stack.isEmpty()) -1 else stack.peek()
        stack.push(i)
    }
    while (stack.isNotEmpty()) {
        val t = stack.pop()
        result = maxOf(result, (n - left[t] - 1) * heights[t])
    }
    return result
}
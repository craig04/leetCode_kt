package cn_solution

import kotlin.math.absoluteValue

private fun maximumSumOfHeights(maxHeights: List<Int>): Long {
    fun calculateArea(indices: IntProgression, pivot: Int): LongArray {
        val sum = LongArray(maxHeights.size)
        val stack = ArrayList<Int>()
        for (i in indices) {
            while (stack.isNotEmpty() && maxHeights[i] < maxHeights[stack.last()])
                stack.removeAt(stack.lastIndex)
            val prev = stack.lastOrNull() ?: pivot
            sum[i] = (i - prev).absoluteValue * maxHeights[i].toLong()
            if (prev != pivot)
                sum[i] += sum[prev]
            stack.add(i)
        }
        return sum
    }

    val left = calculateArea(maxHeights.indices, -1)
    val right = calculateArea(maxHeights.indices.reversed(), maxHeights.size)
    return maxHeights.indices.maxOf { left[it] + right[it] - maxHeights[it] }
}
package cn_solution

import java.util.*

fun finalPrices(prices: IntArray): IntArray {
    val result = IntArray(prices.size)
    val stack = Stack<Int>()
    stack.push(0)
    for (i in prices.indices.reversed()) {
        val p = prices[i]
        while (stack.peek() > p)
            stack.pop()
        result[i] = if (stack.size == 1) p else p - stack.peek()
        stack.push(p)
    }
    return result
}
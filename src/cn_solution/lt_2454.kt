package cn_solution

import java.util.*

fun secondGreaterElement(nums: IntArray): IntArray {
    val n = nums.size
    val result = IntArray(n) { -1 }
    val stack0 = Stack<Int>()
    val stack1 = Stack<Int>()
    val bridge = Stack<Int>()
    nums.forEachIndexed { i, num ->
        while (stack1.isNotEmpty() && nums[stack1.peek()] < num)
            result[stack1.pop()] = num
        while (stack0.isNotEmpty() && nums[stack0.peek()] < num)
            bridge.push(stack0.pop())
        while (bridge.isNotEmpty())
            stack1.push(bridge.pop())
        stack0.add(i)
    }
    return result
}
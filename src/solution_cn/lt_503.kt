package solution_cn

import java.util.*

fun nextGreaterElements(nums: IntArray): IntArray {
    val size = nums.size
    val stack = LinkedList<Int>()
    val result = IntArray(size) { -1 }
    for (i in 0 until size * 2) {
        val j = i % size
        val num = nums[j]
        while (stack.isNotEmpty() && nums[stack.peek()] < num) {
            result[stack.pop()] = num
        }
        stack.push(j)
    }
    return result
}
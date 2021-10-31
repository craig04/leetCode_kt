package solution_cn

import java.util.*
import kotlin.collections.HashMap

fun nextGreaterElement(nums1: IntArray, nums2: IntArray): IntArray {
    val map = HashMap<Int, Int>()
    val stack = Stack<Int>()
    stack.push(Int.MAX_VALUE)
    for (n in nums2) {
        while (n > stack.peek()) {
            map[stack.pop()] = n
        }
        stack.push(n)
    }
    return IntArray(nums1.size) { map[nums1[it]] ?: -1 }
}
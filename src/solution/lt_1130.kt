package solution

import java.util.*

fun mctFromLeafValues(arr: IntArray): Int {

    var result = 0
    val stack = LinkedList<Int>().apply { add(Int.MAX_VALUE) }
    arr.forEach {
        while (stack.peekLast() < it) {
            val last = stack.pollLast()!!
            result += minOf(stack.peekLast(), it) * last
        }
        stack.addLast(it)
    }
    while (stack.size > 2) {
        val last = stack.pollLast()!!
        result += last * stack.peekLast()
    }
    return result
}
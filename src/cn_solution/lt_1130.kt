package cn_solution

fun mctFromLeafValues(arr: IntArray): Int {
    var result = 0
    val stack = arrayListOf(Int.MAX_VALUE)
    for (a in arr) {
        while (stack.last() < a) {
            val top = stack.removeAt(stack.lastIndex)
            result += (if (stack.last() >= a) a else stack.last()) * top
        }
        stack.add(a)
    }
    while (stack.size >= 3)
        result += stack.removeAt(stack.lastIndex) * stack.last()
    return result
}
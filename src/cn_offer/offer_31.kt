package cn_offer

fun validateStackSequences(pushed: IntArray, popped: IntArray): Boolean {
    val stack = ArrayList<Int>()
    var pos = 0
    return popped.all {
        while (stack.lastOrNull() != it) {
            if (pos == pushed.size)
                return false
            stack.add(pushed[pos++])
        }
        stack.removeAt(stack.lastIndex)
        true
    }
}
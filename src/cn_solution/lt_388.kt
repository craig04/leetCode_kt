package cn_solution

fun lengthLongestPath(input: String): Int {
    var pos = 0
    var result = 0
    val stack = ArrayList<Int>()
    while (pos < input.length) {
        var tab = 0
        var end = pos
        var file = false
        while (end != input.length) {
            val c = input[end]
            if (c == '\n') break
            if (c == '\t') tab++
            file = file or (c == '.')
            end++
        }
        val len = end - pos - tab
        while (stack.size > tab)
            stack.removeAt(stack.lastIndex)
        if (file)
            result = maxOf(result, len + (stack.lastOrNull() ?: 0))
        else
            stack.add(len + 1 + (stack.lastOrNull() ?: 0))
        pos = end + 1
    }
    return result
}
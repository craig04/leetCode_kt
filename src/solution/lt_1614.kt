package solution

fun maxDepth(s: String): Int {
    var depth = 0
    var result = 0
    s.forEach {
        if (it == '(') {
            depth++
        } else if (it == ')') {
            depth--
        }
        result = maxOf(result, depth)
    }
    return result
}
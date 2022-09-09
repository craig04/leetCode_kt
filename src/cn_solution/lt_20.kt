package cn_solution

fun isValid(s: String): Boolean {
    val stack = CharArray(s.length)
    var p = 1
    for (c in s) {
        when (c) {
            ')' -> if (stack[--p] != '(') return false
            ']' -> if (stack[--p] != '[') return false
            '}' -> if (stack[--p] != '{') return false
            else -> stack[p++] = c
        }
    }
    return p == 1
}

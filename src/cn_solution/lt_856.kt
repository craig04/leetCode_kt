package cn_solution

fun scoreOfParentheses(s: String): Int {
    var last = ' '
    var depth = 0
    var result = 0
    for (c in s) {
        if (c == '(') depth++ else depth--
        if (c == ')' && last == '(')
            result += 1 shl depth
        last = c
    }
    return result
}

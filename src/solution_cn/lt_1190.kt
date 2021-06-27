package solution_cn

import java.util.*

fun reverseParentheses(s: String): String {
    val ca = s.toCharArray()
    val stack = Stack<Int>()
    s.forEachIndexed { i, c ->
        if (c == '(') {
            stack.push(i)
        } else if (c == ')') {
            ca.reverse(stack.pop(), i)
        }
    }
    return buildString {
        ca.forEach { if (it != '(' && it != ')') append(it) }
    }
}

private fun CharArray.reverse(begin: Int, end: Int) {
    var p = begin
    var q = end
    var temp: Char
    while (p < q) {
        temp = get(p)
        set(p++, get(q))
        set(q--, temp)
    }
}
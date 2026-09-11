package cn_solution

fun reverseParentheses(s: String): String {
    val p = IntArray(s.length) { -1 }
    val a = ArrayList<Int>()
    for (i in s.indices) {
        if (s[i] == '(')
            a += i
        else if (s[i] == ')') {
            val j = a.removeLast()
            p[i] = j
            p[j] = i
        }
    }
    val sb = StringBuilder()
    var i = 0
    var step = 1
    while (i != s.length) {
        if (s[i] == '(' || s[i] == ')') {
            step = -step
            i = p[i]
        } else
            sb.append(s[i])
        i += step
    }
    return sb.toString()
}
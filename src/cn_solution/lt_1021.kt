package cn_solution

fun removeOuterParentheses(s: String): String {
    return buildString {
        var layer = 0
        for (c in s) {
            when (c) {
                '(' -> if (++layer != 1) append(c)
                ')' -> if (--layer != 0) append(c)
            }
        }
    }
}
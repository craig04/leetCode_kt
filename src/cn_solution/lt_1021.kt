package cn_solution

fun removeOuterParentheses(s: String): String {
    var layer = 0
    return s.filter { (if (it == '(') layer++ else --layer) != 0 }
}
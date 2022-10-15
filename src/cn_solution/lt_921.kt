package cn_solution

fun minAddToMakeValid(s: String): Int {
    var result = 0
    var left = 0
    for (c in s) {
        when {
            c == '(' -> left++
            left != 0 -> left--
            else -> result++
        }
    }
    return result + left
}

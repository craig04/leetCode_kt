package cn_solution

fun checkString(s: String): Boolean {
    return (0 until s.lastIndex).none { s[it] == 'b' && s[it + 1] == 'a' }
}
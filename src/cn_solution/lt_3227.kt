package cn_solution

fun doesAliceWin(s: String): Boolean {
    return s.any { it in "aeiou" }
}
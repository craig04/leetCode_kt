package cn_solution

private fun doesAliceWin(s: String): Boolean {
    return s.any { it in "aeiou" }
}
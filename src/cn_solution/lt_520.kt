package cn_solution

fun detectCapitalUse(word: String): Boolean {
    val c = word.count { it.isUpperCase() }
    return c == 0 || c == word.length || (c == 1 && word.first().isUpperCase())
}
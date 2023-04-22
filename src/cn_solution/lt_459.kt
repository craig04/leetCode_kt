package cn_solution

fun repeatedSubstringPattern(s: String): Boolean {
    val n = s.length
    return (1..n / 2).any { n % it == 0 && s.startsWith(s.substring(it)) }
}
package cn_solution

fun isPalindromic(s: String): Boolean {
    val n = s.length
    return (0..n / 2).all {
        Integer.reverse(s[it].code).shr(24) == s[n - 1 - it].code
    }
}
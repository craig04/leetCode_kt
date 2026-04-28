package cn_solution

fun countGoodSubstrings(s: String): Int {
    return (0 until s.length - 2).count { i -> s[i] != s[i + 1] && s[i] != s[i + 2] && s[i + 1] != s[i + 2] }
}
package cn_solution

fun scoreOfString(s: String): Int {
    return (1 until s.length).sumOf { kotlin.math.abs(s[it] - s[it - 1]) }
}
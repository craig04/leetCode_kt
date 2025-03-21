package cn_solution

fun reverseDegree(s: String): Int {
    return s.indices.sumOf { ('z' + 1 - s[it]) * (it + 1) }
}
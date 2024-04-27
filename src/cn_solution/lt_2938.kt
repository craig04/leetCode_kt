package cn_solution

fun minimumSteps(s: String): Long {
    var i = 0L
    return s.indices.sumOf { if (s[it] == '1') 0L else it - i++ }
}
package cn_solution

fun minimizedStringLength(s: String): Int {
    return s.toHashSet().size
}
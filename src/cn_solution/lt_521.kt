package cn_solution

fun findLUSlength(a: String, b: String): Int {
    return if (a == b) -1 else maxOf(a.length, b.length)
}
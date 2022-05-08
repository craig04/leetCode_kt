package cn_solution

fun hasAlternatingBits(n: Int): Boolean {
    val a = n.and(n - 1)
    return a.and(a + 1) == 0
}
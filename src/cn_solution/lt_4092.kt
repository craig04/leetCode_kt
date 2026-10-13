package cn_solution

fun calculateScore(a: Int, b: Int): Int {
    val s1 = a.countOneBits()
    val s2 = b.countOneBits()
    return if (s1 >= s2) s1 * s2 else s2 / s1
}
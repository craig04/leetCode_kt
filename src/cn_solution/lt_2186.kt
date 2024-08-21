package cn_solution

fun minSteps(s: String, t: String): Int {
    val a = IntArray(26)
    for (c in s)
        a[c - 'a']++
    for (c in t)
        a[c - 'a']--
    return a.sumOf { kotlin.math.abs(it) }
}
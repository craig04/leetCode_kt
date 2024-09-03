package cn_solution

fun reverseStr(s: String, k: Int): String {
    val c = s.toCharArray()
    for (i in s.indices.step(k * 2)) {
        val j = minOf(i + k, s.length)
        c.reverse(i, j)
    }
    return String(c)
}
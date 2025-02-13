package cn_solution

fun smallestEquivalentString(s1: String, s2: String, baseStr: String): String {
    val p = IntArray(26) { it }
    fun find(x: Int): Int {
        if (p[x] != x)
            p[x] = find(p[x])
        return p[x]
    }
    for (i in s1.indices) {
        val x = find(s1[i] - 'a')
        val y = find(s2[i] - 'a')
        if (x != y)
            p[maxOf(x, y)] = minOf(x, y)
    }
    return String(CharArray(baseStr.length) { 'a' + find(baseStr[it] - 'a') })
}
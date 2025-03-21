package cn_solution

fun numberOfComponents(properties: Array<IntArray>, k: Int): Int {
    val n = properties.size
    val sets = Array(n) { properties[it].toHashSet() }
    val p = IntArray(n) { it }
    fun find(x: Int): Int {
        if (p[x] != x)
            p[x] = find(p[x])
        return p[x]
    }
    for (i in 1 until n)
        for (j in 0 until i)
            if (sets[i].count { it in sets[j] } >= k)
                p[find(i)] = find(j)
    return p.indices.count { find(it) == it }
}
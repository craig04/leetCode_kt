package cn_solution

fun assignElements_enumerateGroups(groups: IntArray, elements: IntArray): IntArray {
    val idx = IntArray(100001) { Int.MAX_VALUE }
    for (i in elements.indices.reversed())
        idx[elements[i]] = i
    return IntArray(groups.size) {
        var res = Int.MAX_VALUE
        val g = groups[it]
        var r = 1
        while (r * r <= g) {
            if (g % r == 0)
                res = minOf(res, idx[r], idx[g / r])
            r++
        }
        if (res == Int.MAX_VALUE) -1 else res
    }
}

fun assignElements_enumerateElements(groups: IntArray, elements: IntArray): IntArray {
    val pos = IntArray(100001) { -1 }
    elements.forEachIndexed { i, e ->
        if (pos[e] != -1)
            return@forEachIndexed
        for (t in e until pos.size step e)
            if (pos[t] == -1)
                pos[t] = i
    }
    return IntArray(groups.size) { pos[groups[it]] }
}
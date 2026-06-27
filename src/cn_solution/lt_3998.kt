package cn_solution

fun transformStr(s: String, strs: Array<String>): BooleanArray {
    val idx = s.indices.filter { s[it] == '0' }.toIntArray()
    return BooleanArray(strs.size) {
        val p = strs[it]
        var z = 0
        var q = 0
        for (i in p.indices) {
            when (p[i]) {
                '0' -> z++
                '?' -> q++
            }
        }
        if (z > idx.size || z + q < idx.size)
            return@BooleanArray false
        q = idx.size - z
        var j = 0
        idx.all { i ->
            while (p[j] == '1' || p[j] == '?' && --q < 0)
                j++
            i >= j++
        }
    }
}
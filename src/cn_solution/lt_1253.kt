package cn_solution

fun reconstructMatrix(upper: Int, lower: Int, colsum: IntArray): List<List<Int>> {
    val m = Array(2) { IntArray(colsum.size) }
    var u = upper
    var l = lower
    colsum.forEachIndexed { i, s ->
        if (s == 2) {
            if (--l < 0 || --u < 0)
                return emptyList()
            m[0][i] = 1
            m[1][i] = 1
        }
    }
    colsum.forEachIndexed { i, s ->
        if (s == 1) {
            when {
                --u >= 0 -> m[0][i] = 1
                --l >= 0 -> m[1][i] = 1
                else -> return emptyList()
            }
        }
    }
    return if (l == 0) m.map { it.asList() } else emptyList()
}
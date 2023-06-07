package cn_interview

fun pondSizes(land: Array<IntArray>): IntArray {
    val pool = ArrayList<Int>()
    val row = land.indices
    val col = land[0].indices
    val x = intArrayOf(-1, -1, -1, 0, 0, 1, 1, 1)
    val y = intArrayOf(-1, 0, 1, -1, 1, -1, 0, 1)
    fun dfs(i: Int, j: Int): Int {
        if (land[i][j] != 0)
            return 0
        land[i][j] = Int.MAX_VALUE
        return x.indices.sumBy {
            val p = x[it] + i
            val q = y[it] + j
            if (p !in row || q !in col) 0 else dfs(p, q)
        }
    }
    for (i in row)
        for (j in col) {
            val size = dfs(i, j)
            if (size != 0)
                pool.add(size)
        }
    return IntArray(pool.size) { pool[it] }.apply { sort() }
}
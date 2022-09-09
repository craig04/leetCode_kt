package cn_solution

fun generate(numRows: Int): List<List<Int>> {
    val tri = Array(numRows) { IntArray(it + 1) }
    for (i in 0 until numRows) {
        tri[i][0] = 1
        tri[i][i] = 1
        for (j in 1 until i) {
            tri[i][j] = tri[i - 1][j - 1] + tri[i - 1][j]
        }
    }
    return tri.map { it.asList() }
}

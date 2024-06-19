package cn_solution

fun maxIncreasingCells(mat: Array<IntArray>): Int {
    val n = mat.size
    val m = mat[0].size
    val a = Array(m * n) {
        val x = it / m
        val y = it % m
        intArrayOf(mat[x][y], x, y, 0)
    }
    a.sortByDescending { it[0] }
    val row = IntArray(n)
    val col = IntArray(m)
    var i = 0
    var j = 0
    while (j != a.size) {
        while (j != a.size && a[j][0] == a[i][0])
            j++
        for (k in i until j) {
            a[k][3] = 1 + maxOf(row[a[k][1]], col[a[k][2]])
        }
        for (k in i until j) {
            val x = a[k][1]
            val y = a[k][2]
            row[x] = maxOf(row[x], a[k][3])
            col[y] = maxOf(col[y], a[k][3])
        }
        i = j
    }
    return row.max()
}
package cn_solution

fun firstCompleteIndex(arr: IntArray, mat: Array<IntArray>): Int {
    val n = mat.size
    val m = mat[0].size
    val row = IntArray(n * m)
    val col = IntArray(n * m)
    for (i in mat.indices)
        for (j in mat[i].indices) {
            row[mat[i][j]] = i
            col[mat[i][j]] = j
        }
    val r = IntArray(n)
    val c = IntArray(m)
    return arr.indexOfFirst { ++r[row[it]] == m && ++c[col[it]] == n }
}
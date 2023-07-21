package cn_solution

fun diagonalSum(mat: Array<IntArray>): Int {
    val n = mat.size
    var result = mat.indices.sumBy {
        mat[it][it] + mat[it][n - 1 - it]
    }
    if (n and 1 == 1)
        result -= mat[n shr 1][n shr 1]
    return result
}
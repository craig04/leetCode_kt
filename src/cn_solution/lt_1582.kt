package cn_solution

fun numSpecial(mat: Array<IntArray>): Int {
    val rows = IntArray(mat.size)
    val cols = IntArray(mat[0].size)
    for (i in mat.indices)
        for (j in mat[i].indices) {
            rows[i] += mat[i][j]
            cols[j] += mat[i][j]
        }
    var result = 0
    for (i in mat.indices)
        for (j in mat[0].indices)
            if (mat[i][j] == 1 && rows[i] == 1 && cols[j] == 1)
                result++
    return result
}
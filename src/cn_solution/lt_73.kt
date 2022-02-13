package cn_solution

import java.util.*

fun setZeroes(matrix: Array<IntArray>) {
    val r = matrix[0].any { it == 0 }
    val c = matrix.any { it[0] == 0 }
    val rows = 1 until matrix.size
    val cols = 1 until matrix[0].size
    for (i in rows)
        for (j in cols)
            if (matrix[i][j] == 0) {
                matrix[i][0] = 0
                matrix[0][j] = 0
            }
    for (i in rows)
        if (matrix[i][0] == 0)
            Arrays.fill(matrix[i], 0)
    for (j in cols)
        if (matrix[0][j] == 0)
            for (a in matrix) a[j] = 0
    if (r)
        matrix[0].fill(0)
    if (c)
        for (a in matrix)
            a[0] = 0
}

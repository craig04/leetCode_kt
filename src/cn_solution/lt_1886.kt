package cn_solution

fun findRotation(mat: Array<IntArray>, target: Array<IntArray>): Boolean {
    val n = mat.size
    var diff = 0
    for (i in 0 until n)
        for (j in 0 until n) {
            val t = target[i][j]
            if (t != mat[i][j])
                diff = diff or 1
            if (t != mat[n - 1 - j][i])
                diff = diff or 2
            if (t != mat[n - 1 - i][n - 1 - j])
                diff = diff or 4
            if (t != mat[j][n - 1 - i])
                diff = diff or 8
            if (diff == 15)
                return false
        }
    return true
}
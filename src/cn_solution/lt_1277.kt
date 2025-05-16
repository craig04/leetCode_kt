package cn_solution

fun countSquares(matrix: Array<IntArray>): Int {
    var ans = 0
    val n = matrix.size
    val m = matrix[0].size
    for (i in 0 until n)
        for (j in 0 until m) {
            if (i != 0 && j != 0 && matrix[i][j] == 1)
                matrix[i][j] = minOf(
                    matrix[i - 1][j],
                    matrix[i][j - 1],
                    matrix[i - 1][j - 1]
                ) + 1
            ans += matrix[i][j]
        }
    return ans
}
package cn_interview

fun findSquare(matrix: Array<IntArray>): IntArray {
    val n = matrix.size
    val up = Array(n + 1) { IntArray(n + 1) }
    val left = Array(n + 1) { IntArray(n + 1) }
    val result = IntArray(3)
    for (i in 1..n) {
        for (j in 1..n) {
            if (matrix[i - 1][j - 1] == 0) {
                up[i][j] = up[i - 1][j] + 1
                left[i][j] = left[i][j - 1] + 1
                var size = minOf(up[i][j], left[i][j]) - 1
                while (size >= result[2]) {
                    if (up[i][j - size] > size && left[i - size][j] > size) {
                        result[0] = i - size - 1
                        result[1] = j - size - 1
                        result[2] = size + 1
                    }
                    size--
                }
            }
        }
    }
    return if (result[2] == 0) intArrayOf() else result
}
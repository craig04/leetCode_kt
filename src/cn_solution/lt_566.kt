package cn_solution

fun matrixReshape(mat: Array<IntArray>, r: Int, c: Int): Array<IntArray> {
    val n = mat.size
    val m = mat[0].size
    if (n * m != r * c) {
        return mat
    }
    val result = Array(r) { IntArray(c) }
    for (i in 0 until n * m)
        result[i / c][i % c] = mat[i / m][i % m]
    return result
}

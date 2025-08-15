package cn_solution

fun transpose(matrix: Array<IntArray>): Array<IntArray> {
    val n = matrix.size
    val m = matrix[0].size
    return Array(m) { i -> IntArray(n) { j -> matrix[j][i] } }
}
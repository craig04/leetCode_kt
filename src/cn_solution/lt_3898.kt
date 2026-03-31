package cn_solution

fun findDegrees(matrix: Array<IntArray>): IntArray {
    return IntArray(matrix.size) { matrix[it].sum() }
}
package cn_solution

fun luckyNumbers(matrix: Array<IntArray>): List<Int> {
    val minNum = Array(matrix.size) { matrix[it].minOrNull() }
    val maxNum = Array(matrix[0].size) {
        matrix.indices.fold(Int.MIN_VALUE) { t, i -> maxOf(t, matrix[i][it]) }
    }
    val result = ArrayList<Int>()
    for (i in matrix.indices) {
        for (j in matrix[0].indices) {
            val num = matrix[i][j]
            if (num == minNum[i] && num == maxNum[j]) {
                result.add(num)
            }
        }
    }
    return result
}
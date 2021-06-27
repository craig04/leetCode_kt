package solution_cn

fun numSubmatrixSumTarget(matrix: Array<IntArray>, target: Int): Int {
    for (i in 1 until matrix.size) {
        for (j in matrix[0].indices) {
            matrix[i][j] += matrix[i - 1][j]
        }
    }
    var result = 0
    val map = HashMap<Int, Int>()
    for (b in matrix.indices) {
        for (e in b until matrix.size) {
            map.clear()
            map[0] = 1
            var sum = 0
            for (j in 0 until matrix[0].size) {
                sum += matrix[e][j]
                if (b != 0)
                    sum -= matrix[b - 1][j]
                result += map[sum - target] ?: 0
                map[sum] = (map[sum] ?: 0) + 1
            }
        }
    }
    return result
}
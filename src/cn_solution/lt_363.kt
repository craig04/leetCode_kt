package cn_solution

fun maxSumSubmatrix(matrix: Array<IntArray>, k: Int): Int {
    val n = matrix.size
    val m = matrix.first().size
    val sums = Array(n) {
        val a = IntArray(m + 1)
        for (i in 1..m) {
            a[i] = a[i - 1] + matrix[it][i - 1]
        }
        a
    }
    var result = Int.MIN_VALUE
    for (i in 0 until m) {
        for (j in i + 1..m) {
            var temp = 0
            val set = sortedSetOf(0)
            for (r in 0 until n) {
                temp += sums[r][j] - sums[r][i]
                set.ceiling(temp - k)?.let {
                    result = maxOf(result, temp - it)
                }
                set.add(temp)
            }
        }
    }
    return result
}

/**
 * Brute force
 * O(n*n * m*m)
 */
fun maxSumSubmatrix_2(matrix: Array<IntArray>, k: Int): Int {
    val n = matrix.size
    val m = matrix.first().size
    val sums = Array(n + 1) { IntArray(m + 1) }
    for (i in 0 until n)
        for (j in 0 until m)
            sums[i + 1][j + 1] = sums[i + 1][j] + sums[i][j + 1] - sums[i][j] + matrix[i][j]
    var result = Int.MIN_VALUE
    for (i in 0 until n) {
        for (j in 0 until m) {
            for (p in i + 1..n) {
                for (q in j + 1..m) {
                    val s = sums[p][q] - sums[p][j] - sums[i][q] + sums[i][j]
                    if (s <= k) {
                        result = result.coerceAtLeast(s)
                    }
                }
            }
        }
    }
    return result
}
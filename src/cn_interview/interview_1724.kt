package cn_interview

fun getMaxMatrix(matrix: Array<IntArray>): IntArray {
    val n = matrix.size
    val m = matrix[0].size
    val pre = Array(n + 1) { IntArray(m) }
    for (i in 0 until n)
        for (j in 0 until m)
            pre[i + 1][j] = pre[i][j] + matrix[i][j]
    var (result, t, l, b, r) = intArrayOf(Int.MIN_VALUE, 0, 0, 0, 0)
    for (top in 0 until n) {
        for (bottom in top until n) {
            var sum = 0
            var left = 0
            for (right in 0 until m) {
                val data = pre[bottom + 1][right] - pre[top][right]
                if (sum < 0) {
                    sum = data
                    left = right
                } else {
                    sum += data
                }
                if (sum > result) {
                    result = sum
                    t = top
                    l = left
                    b = bottom
                    r = right
                }
            }
        }
    }
    return intArrayOf(t, l, b, r)
}
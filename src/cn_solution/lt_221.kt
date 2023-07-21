package cn_solution

fun maximalSquare(matrix: Array<CharArray>): Int {
    val m = matrix[0].size
    var result = 0
    var pre = IntArray(m + 1)
    var cur = IntArray(m + 1)
    for (line in matrix) {
        line.forEachIndexed { i, c ->
            cur[i + 1] = if (c == '0')
                0
            else
                minOf(cur[i], pre[i], pre[i + 1]) + 1
            result = maxOf(result, cur[i + 1])
        }
        val tmp = cur
        cur = pre
        pre = tmp
    }
    return result * result
}
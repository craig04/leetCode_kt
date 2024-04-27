package cn_solution

fun kthSmallestPath(destination: IntArray, k: Int): String {
    var (row, col) = destination
    val total = row + col
    val c = Array(total + 1) { IntArray(total + 1) }
    for (i in 0..total) {
        c[i][0] = 1
        for (j in 1..i)
            c[i][j] = c[i - 1][j] + c[i - 1][j - 1]
    }
    val sb = StringBuilder()
    var idx = k - 1
    while (idx != 0) {
        val cnt = c[row + col - 1][col - 1]
        if (idx < cnt) {
            sb.append('H')
            col--
        } else {
            sb.append('V')
            row--
            idx -= cnt
        }
    }
    repeat(col) { sb.append('H') }
    repeat(row) { sb.append('V') }
    return sb.toString()
}
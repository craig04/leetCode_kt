package cn_solution

fun oddCells(m: Int, n: Int, indices: Array<IntArray>): Int {
    var row = 0L
    var col = 0L
    for ((i, j) in indices) {
        row = row xor 1L.shl(i)
        col = col xor 1L.shl(j)
    }
    val rows = java.lang.Long.bitCount(row)
    val cols = java.lang.Long.bitCount(col)
    return rows * (n - cols) + cols * (m - rows)
}
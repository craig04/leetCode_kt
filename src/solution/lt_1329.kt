package solution

fun diagonalSort(mat: Array<IntArray>): Array<IntArray> {
    val row = mat.size
    val col = mat[0].size
    val tmp = IntArray(minOf(row, col))
    val res = Array(row) { IntArray(col) }
    for (i in 0 until row + col - 1) {
        val len = mat.diagonal(i) { r, c, idx -> tmp[idx] = mat[r][c] }
        tmp.sort(toIndex = len)
        res.diagonal(i) { r, c, idx -> res[r][c] = tmp[idx] }
    }
    return res
}

private fun Array<IntArray>.diagonal(index: Int, function: (Int, Int, Int) -> Unit): Int {
    val row = size
    val col = this[0].size
    var i = maxOf(row - 1 - index, 0)
    var j = maxOf(0, index - row + 1)
    var idx = 0
    while (i < row && j < col) {
        function(i++, j++, idx++)
    }
    return idx
}
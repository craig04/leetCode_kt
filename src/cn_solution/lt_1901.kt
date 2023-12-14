package cn_solution

fun findPeakGrid(mat: Array<IntArray>): IntArray {
    fun IntArray.maxIndex() = indices.reduce { a, b -> if (this[a] > this[b]) a else b }
    var l = 0
    var r = mat.lastIndex
    while (l != r) {
        val m = (l + r) shr 1
        val pos = mat[m].maxIndex()
        val largest = mat[m][pos]
        if (m != mat.lastIndex && mat[m + 1][pos] > largest) {
            l = m + 1
        } else if (m != 0 && mat[m - 1][pos] > largest) {
            r = m
        } else {
            return intArrayOf(m, pos)
        }
    }
    return intArrayOf(r, mat[r].maxIndex())
}
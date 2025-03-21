package cn_solution

fun rowAndMaximumOnes(mat: Array<IntArray>): IntArray {
    var row = 0
    var max = 0
    for (i in mat.indices) {
        val cnt = mat[i].sum()
        if (cnt > max) {
            row = i
            max = cnt
        }
    }
    return intArrayOf(row, max)
}
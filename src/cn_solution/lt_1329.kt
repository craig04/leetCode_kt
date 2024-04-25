package cn_solution

fun diagonalSort(mat: Array<IntArray>): Array<IntArray> {
    val n = mat.size
    val m = mat[0].size
    val list = Array(n + m) { ArrayList<Int>() }
    for (i in 0 until n)
        for (j in 0 until m)
            list[j - i + n].add(mat[i][j])
    list.forEach { it.sortDescending() }
    for (i in 0 until n)
        for (j in 0 until m)
            mat[i][j] = list[j - i + n].removeLast()
    return mat
}
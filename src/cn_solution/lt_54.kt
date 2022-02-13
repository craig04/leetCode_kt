package cn_solution

fun spiralOrder(matrix: Array<IntArray>): List<Int> {
    val list = ArrayList<Int>()
    var t = 0
    var b = matrix.lastIndex
    var l = 0
    var r = matrix.last().lastIndex
    while (l <= r && t <= b) {
        for (i in l..r) list.add(matrix[t][i])
        for (i in t + 1..b) list.add(matrix[i][r])
        if (l == r || t == b) break
        for (i in r - 1 downTo l) list.add(matrix[b][i])
        for (i in b - 1 downTo t + 1) list.add(matrix[i][l])
        t++
        b--
        l++
        r--
    }
    return list
}
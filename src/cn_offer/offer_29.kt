package cn_offer

fun spiralOrder(matrix: Array<IntArray>): IntArray {
    val list = ArrayList<Int>()
    if (matrix.isEmpty() || matrix[0].isEmpty())
        return list.toIntArray()
    var t = 0
    var b = matrix.lastIndex
    var l = 0
    var r = matrix.last().lastIndex
    while (l <= r && t <= b) {
        for (i in l..r)
            list.add(matrix[t][i])
        for (i in t + 1..b)
            list.add(matrix[i][r])
        if (l == r || t == b)
            break
        for (i in r - 1 downTo l)
            list.add(matrix[b][i])
        for (i in b - 1 downTo t + 1)
            list.add(matrix[i][l])
        t++
        b--
        l++
        r--
    }
    return list.toIntArray()
}
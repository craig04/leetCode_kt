package cn_lcr

fun minPathSum(grid: Array<IntArray>): Int {
    val temp = IntArray(grid[0].size + 1) { Int.MAX_VALUE }
    temp[1] = 0
    for (row in grid) {
        for (i in row.indices)
            temp[i + 1] = minOf(temp[i], temp[i + 1]) + row[i]
    }
    return temp.last()
}
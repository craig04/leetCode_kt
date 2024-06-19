package cn_solution

fun goodSubsetofBinaryMatrix(grid: Array<IntArray>): List<Int> {
    val us = 1.shl(grid[0].size) - 1
    val pos = IntArray(us) { -1 }
    for (i in grid.indices) {
        val row = grid[i]
        val s = row.indices.sumOf { 1.shl(it) * row[it] }
        if (s == 0)
            return listOf(i)
        if (pos[s] != -1)
            continue
        val cs = s xor us
        var t = cs
        while (t != 0) {
            if (pos[t] != -1)
                return listOf(pos[t], i)
            t = (t - 1) and cs
        }
        pos[s] = i
    }
    return emptyList()
}
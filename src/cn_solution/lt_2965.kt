package cn_solution

fun findMissingAndRepeatedValues(grid: Array<IntArray>): IntArray {
    var all = 0
    for (i in grid.indices)
        for (j in grid[i].indices)
            all = all xor (i * grid[i].size + j + 1) xor grid[i][j]
    val lowbit = all.takeLowestOneBit()
    var a = 0
    var b = 0
    fun xor(t: Int) {
        if (t and lowbit != 0)
            a = a xor t
        else
            b = b xor t
    }
    for (i in grid.indices) {
        for (j in grid[i].indices) {
            xor(i * grid[i].size + j + 1)
            xor(grid[i][j])
        }
    }
    return if (grid.any { a in it })
        intArrayOf(a, b)
    else
        intArrayOf(b, a)
}
package cn_solution

fun numMagicSquaresInside(grid: Array<IntArray>): Int {
    val row = IntArray(3)
    val col = IntArray(3)
    var ans = 0
    for (i in 0 until grid.size - 2)
        for (j in 0 until grid[i].size - 2) {
            if (grid[i + 1][j + 1] != 5)
                continue
            var mask = 0
            row.fill(0)
            col.fill(0)
            for (x in 0 until 3)
                for (y in 0 until 3) {
                    val num = grid[i + x][j + y]
                    row[x] += num
                    col[y] += num
                    mask = mask or (1 shl num)
                }
            if (mask == 1022 && row[0] == 15 && row[1] == 15 && col[0] == 15 && col[1] == 15)
                ans++
        }
    return ans
}
package cn_solution

fun spiralMatrixIII(rows: Int, cols: Int, rStart: Int, cStart: Int): Array<IntArray> {
    val size = rows * cols
    val ans = Array(size) { IntArray(2) }
    ans[0][0] = rStart
    ans[0][1] = cStart
    if (size == 1)
        return ans
    var pos = 1
    var x = rStart
    var y = cStart
    var steps = 1
    val dir = intArrayOf(0, 1, 1, 0, 0, -1, -1, 0)
    loop@ while (true) {
        for (i in dir.indices.step(2)) {
            for (j in 0 until steps + i / 4) {
                x += dir[i]
                y += dir[i + 1]
                if (x in 0 until rows && y in 0 until cols) {
                    ans[pos][0] = x
                    ans[pos][1] = y
                    if (++pos == size)
                        break@loop
                }
            }
        }
        steps += 2
    }
    return ans
}
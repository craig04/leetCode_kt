package cn_solution

fun queensAttacktheKing(queens: Array<IntArray>, king: IntArray): List<List<Int>> {
    val range = 0 until 8
    val q = Array(8) { BooleanArray(8) }
    queens.forEach { (x, y) -> q[x][y] = true }
    val x = intArrayOf(-1, -1, -1, 0, 0, 1, 1, 1)
    val y = intArrayOf(-1, 0, 1, -1, 1, -1, 0, 1)
    val result = ArrayList<List<Int>>()
    for (i in x.indices) {
        var a = king[0] + x[i]
        var b = king[1] + y[i]
        while (a in range && b in range) {
            if (q[a][b]) {
                result.add(listOf(a, b))
                break
            }
            a += x[i]
            b += y[i]
        }
    }
    return result
}
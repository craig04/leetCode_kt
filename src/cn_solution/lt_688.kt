package cn_solution

fun knightProbability(n: Int, k: Int, row: Int, column: Int): Double {
    val range = 0 until n
    var prob = Array(n) { DoubleArray(n) { 1.0 } }
    var next = Array(n) { DoubleArray(n) }
    val steps = intArrayOf(-2, -1, -2, 1, -1, -2, -1, 2, 1, -2, 1, 2, 2, -1, 2, 1)
    fun forEach(action: (i: Int, j: Int) -> Unit) {
        for (i in range)
            for (j in range)
                action(i, j)
    }
    repeat(k) {
        forEach { i, j ->
            for (t in steps.indices step 2) {
                val x = i + steps[t]
                val y = j + steps[t + 1]
                if (x in range && y in range) {
                    next[i][j] += prob[x][y] / 8
                }
            }
        }
        val temp = next
        next = prob
        prob = temp
        forEach { i, j -> next[i][j] = 0.0 }
    }
    return prob[row][column]
}
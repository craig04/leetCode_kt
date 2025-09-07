package cn_solution

fun specialGrid(n: Int): Array<IntArray> {
    val len = 1 shl n
    val ans = Array(len) { IntArray(len) }
    var s = 1
    fun fill(x: Int, y: Int, d: Int) {
        for (i in 0 until s)
            for (j in 0 until s)
                ans[i + x][j + y] = ans[i][j] + d
    }
    repeat(n) {
        val d = s * s
        fill(0, s, 0)
        fill(s, s, d * 1)
        fill(s, 0, d * 2)
        fill(0, 0, d * 3)
        s *= 2
    }
    return ans
}
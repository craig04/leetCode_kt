package cn_solution

fun specialGrid(n: Int): Array<IntArray> {
    var ans = arrayOf(intArrayOf(0))
    repeat(n) {
        val s = ans.size
        val new = Array(s * 2) { IntArray(s * 2) }
        fun fill(x: Int, y: Int, d: Int) {
            for (i in ans.indices)
                for (j in ans[i].indices)
                    new[i + x][j + y] = ans[i][j] + d
        }

        val d = s * s
        fill(0, s, 0)
        fill(s, s, d * 1)
        fill(s, 0, d * 2)
        fill(0, 0, d * 3)
        ans = new
    }
    return ans
}
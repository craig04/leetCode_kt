package cn_solution

fun rotateTheBox(box: Array<CharArray>): Array<CharArray> {
    val n = box.size
    val m = box[0].size
    val ans = Array(m) { CharArray(n) }
    for (i in 0 until n) {
        var pos = m - 1
        for (j in m - 1 downTo 0) {
            ans[j][n - 1 - i] = '.'
            when (box[i][j]) {
                '#' -> ans[pos--][n - 1 - i] = '#'
                '*' -> {
                    ans[j][n - 1 - i] = '*'
                    pos = j - 1
                }
            }
        }
    }
    return ans
}
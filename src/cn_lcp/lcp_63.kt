package cn_lcp

fun ballGame(num: Int, plate: Array<String>): Array<IntArray> {
    val n = plate.size
    val m = plate[0].length
    val dir = arrayOf(-1, 0, 0, 1, 1, 0, 0, -1)
    fun check(x: Int, y: Int, i: Int): Boolean {
        var left = num
        var u = x
        var v = y
        var j = i
        while (left-- != 0) {
            u += dir[j * 2]
            v += dir[j * 2 + 1]
            if (u !in 0 until n || v !in 0 until m)
                break
            when (plate[u][v]) {
                'O' -> return true
                'E' -> j++
                'W' -> j += 3
            }
            j = j and 3
        }
        return false
    }

    val ans = ArrayList<IntArray>()
    for (i in 1 until n - 1) {
        if (plate[i][0] == '.' && check(i, 0, 1))
            ans.add(intArrayOf(i, 0))
        if (plate[i][m - 1] == '.' && check(i, m - 1, 3))
            ans.add(intArrayOf(i, m - 1))
    }
    for (j in 1 until m - 1) {
        if (plate[0][j] == '.' && check(0, j, 2))
            ans.add(intArrayOf(0, j))
        if (plate[n - 1][j] == '.' && check(n - 1, j, 0))
            ans.add(intArrayOf(n - 1, j))
    }
    return ans.toTypedArray()
}
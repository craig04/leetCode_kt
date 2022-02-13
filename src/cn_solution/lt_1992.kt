package cn_solution

fun findFarmland(land: Array<IntArray>): Array<IntArray> {
    val r = land.size
    val c = land[0].size
    val result = ArrayList<IntArray>()
    for (i in land.indices) {
        for (j in land[i].indices) {
            if (land[i][j] == 1) {
                var x = i
                var y = j
                while (x != r && land[x][j] == 1) x++
                while (y != c && land[i][y] == 1) y++
                for (u in i until x) {
                    for (v in j until y) {
                        land[u][v] = 0
                    }
                }
                result.add(intArrayOf(i, j, x - 1, y - 1))
            }
        }
    }
    return result.toTypedArray()
}
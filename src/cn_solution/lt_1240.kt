package cn_solution

fun tilingRectangle(n: Int, m: Int): Int {
    val flag = Array(n) { ByteArray(m) }
    val total = n * m
    val guard = 1.toByte()
    var result = total
    fun dfs(x: Int, y: Int, used: Int, cover: Int) {
        if (used >= result || cover == total) {
            result = minOf(result, used)
            return
        }
        if (flag[x][y] == guard) {
            dfs(x + (y + 1) / m, (y + 1) % m, used, cover)
            return
        }
        for (len in minOf(n - x, m - y) downTo 1) {
            val area = len * len
            var index = 0
            while (index != area) {
                val i = x + index / len
                val j = y + index++ % len
                if (++flag[i][j] != guard)
                    break
            }
            if (index == area)
                dfs(x + (y + len) / m, (y + len) % m, used + 1, cover + area)
            while (--index >= 0)
                --flag[x + index / len][y + index % len]
        }
    }
    dfs(0, 0, 0, 0)
    return result
}
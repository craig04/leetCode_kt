package cn_solution

fun numTilePossibilities(tiles: String): Int {
    val map = HashMap<Char, Int>()
    tiles.forEach { map[it] = (map[it] ?: 0) + 1 }
    val count = map.values.toIntArray()

    fun dfs(i: Int): Int {
        if (i == 0) {
            return 1
        }
        var result = 1
        for (k in count.indices) {
            if (count[k] != 0) {
                count[k]--
                result += dfs(i - 1)
                count[k]++
            }
        }
        return result
    }
    return dfs(tiles.length) - 1
}
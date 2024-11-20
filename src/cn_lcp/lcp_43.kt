package cn_lcp

fun trafficCommand(directions: Array<String>): Int {
    val together = arrayOf(
        intArrayOf(2, 0, 2, 0),
        intArrayOf(2, 3, 3, 0),
        intArrayOf(3, 1, 3, 1),
        intArrayOf(0, 2, 0, 2),
        intArrayOf(3, 3, 0, 2),
        intArrayOf(1, 3, 1, 3),
        intArrayOf(3, 0, 2, 3),
        intArrayOf(0, 2, 3, 3),
        intArrayOf(3, 3, 3, 3)
    )
    val map = IntArray(26)
    "ESWN".forEachIndexed { i, c -> map[c - 'A'] = i }
    val cars = Array(4) { IntArray(directions[it].length) }
    for (i in directions.indices)
        for (j in directions[i].indices)
            cars[i][j] = (map[directions[i][j] - 'A'] + 4 - i) % 4
    val dp = hashMapOf(0 to 0)
    val left = IntArray(4) { directions[it].length }
    fun key() = left.indices.sumOf { left[it].shl(it * 5) }
    fun dfs(): Int = dp.getOrPut(key()) {
        together.minOf { t ->
            val fire = ArrayList<Int>()
            for (i in 0 until 4)
                if (left[i] != 0 && t[i] == cars[i][left[i] - 1]) {
                    left[i]--
                    fire.add(i)
                }
            if (fire.isEmpty())
                return@minOf Int.MAX_VALUE
            val res = dfs() + 1
            for (f in fire)
                left[f]++
            res
        }
    }
    return dfs()
}
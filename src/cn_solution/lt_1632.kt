package cn_solution

fun matrixRankTransform(matrix: Array<IntArray>): Array<IntArray> {
    val n = matrix.size
    val m = matrix.first().size
    val map = HashMap<Int, ArrayList<IntArray>>()
    for (i in 0 until n)
        for (j in 0 until m)
            map.getOrPut(matrix[i][j]) { ArrayList() }.add(intArrayOf(i, j))
    val row = IntArray(n)
    val col = IntArray(m)
    val ans = Array(n) { IntArray(m) }
    for ((_, pos) in map.entries.sortedBy { it.key }) {
        val p = IntArray(pos.size) { it }
        fun find(x: Int): Int {
            if (p[x] != x)
                p[x] = find(p[x])
            return p[x]
        }

        val ranks = IntArray(pos.size)
        val r = HashMap<Int, Int>()
        val c = HashMap<Int, Int>()
        for (i in pos.indices) {
            val (x, y) = pos[i]
            fun last(map: HashMap<Int, Int>, key: Int): Int {
                var j = map.putIfAbsent(key, i) ?: return 0
                j = find(j)
                p[j] = i
                return ranks[j]
            }
            ranks[i] = maxOf(row[x] + 1, col[y] + 1, last(r, x), last(c, y))
        }
        for (i in pos.indices) {
            val (x, y) = pos[i]
            val rank = ranks[find(i)]
            row[x] = rank
            col[y] = rank
            ans[x][y] = rank
        }
    }
    return ans
}
package cn_solution

fun cutOffTree(forest: List<List<Int>>): Int {
    val d = intArrayOf(-1, 0, 0, -1, 0, 1, 1, 0)
    val row = forest.indices
    val col = forest.first().indices
    val order = ArrayList<IntArray>()
    for (i in row)
        for (j in col)
            if (forest[i][j] > 1)
                order.add(intArrayOf(forest[i][j], i, j))
    order.sortBy { it[0] }
    var ans = 0
    var x = 0
    var y = 0
    val q = Array(3072) { IntArray(3) }
    var head = 0
    var tail = 0
    val vis = LongArray(forest.size)
    loop@ for ((_, u, v) in order) {
        q[0][0] = x
        q[0][1] = y
        q[0][2] = 0
        head = 0
        tail = 1
        vis.fill(0)
        vis[x] = 1L.shl(y).or(vis[x])
        while (head != tail) {
            val (a, b, s) = q[head++]
            if (a == u && b == v) {
                ans += s
                x = u
                y = v
                continue@loop
            }
            for (t in d.indices step 2) {
                val i = a + d[t]
                val j = b + d[t + 1]
                val bit = 1L.shl(j)
                if (i in row && j in col && forest[i][j] != 0 && bit.and(vis[i]) == 0L) {
                    vis[i] = bit.or(vis[i])
                    q[tail][0] = i
                    q[tail][1] = j
                    q[tail++][2] = s + 1
                }
            }
        }
        return -1
    }
    return ans
}
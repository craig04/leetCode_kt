package cn_solution

fun maxSubstringLength(s: String, k: Int): Boolean {
    val pos = Array(26) { ArrayList<Int>() }
    s.forEachIndexed { i, c -> pos[c - 'a'].add(i) }
    val g = Array(26) { i ->
        val l = pos[i].firstOrNull() ?: return@Array emptyList()
        val r = pos[i].last()
        (0 until 26).filter { j ->
            if (j == i || pos[j].isEmpty())
                return@filter false
            var x = 0
            var y = pos[j].size
            while (x != y) {
                val z = (x + y) shr 1
                if (pos[j][z] <= l)
                    x = z + 1
                else
                    y = z
            }
            x != pos[j].size && pos[j][x] < r
        }
    }
    val intervals = ArrayList<IntArray>()
    for (i in 0 until 26) {
        if (pos[i].isEmpty())
            continue
        var l = Int.MAX_VALUE
        var r = Int.MIN_VALUE
        fun dfs(u: Int) {
            if (pos[u].first() < l || pos[u].last() > r) {
                l = minOf(l, pos[u].first())
                r = maxOf(r, pos[u].last())
                for (v in g[u])
                    dfs(v)
            }
        }
        dfs(i)
        if (l != 0 || r != s.lastIndex)
            intervals.add(intArrayOf(l, r))
    }
    intervals.sortBy { it[1] }
    var right = Int.MIN_VALUE
    var choose = 0
    for ((l, r) in intervals)
        if (l > right) {
            right = r
            choose++
        }
    return choose >= k
}
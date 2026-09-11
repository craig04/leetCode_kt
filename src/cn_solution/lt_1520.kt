package cn_solution

fun maxNumOfSubstrings(s: String): List<String> {
    val pos = Array(26) { ArrayList<Int>() }
    for (i in s.indices)
        pos[s[i] - 'a'] += i
    val g = Array(26) { ArrayList<Int>() }
    for (i in 0 until 26) {
        if (pos[i].isEmpty())
            continue
        val l = pos[i].first()
        val r = pos[i].last()
        for (j in 0 until 26) {
            var t = pos[j].binarySearch(l)
            if (t < 0)
                t = -t - 1
            if (t != pos[j].size && pos[j][t] <= r)
                g[i] += j
        }
    }
    val vis = IntArray(26) { -1 }
    val intervals = ArrayList<IntArray>()
    for (i in 0 until 26) {
        if (pos[i].isEmpty())
            continue
        var l = Int.MAX_VALUE
        var r = Int.MIN_VALUE
        fun dfs(x: Int) {
            if (vis[x] == i)
                return
            vis[x] = i
            l = minOf(l, pos[x].first())
            r = maxOf(r, pos[x].last())
            g[x].forEach(::dfs)
        }
        dfs(i)
        intervals += intArrayOf(l, r + 1)
    }
    intervals.sortBy { it[1] }
    val ans = ArrayList<String>()
    var right = 0
    for ((l, r) in intervals)
        if (right <= l) {
            right = r
            ans += s.substring(l, r)
        }
    return ans
}
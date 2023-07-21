package cn_solution

fun minNumberOfSemesters(n: Int, relations: Array<IntArray>, k: Int): Int {
    val degree = IntArray(n + 1)
    val adj = Array(n + 1) { ArrayList<Int>() }
    relations.forEach { (a, b) ->
        degree[b]++
        adj[a].add(b)
    }
    val dp = IntArray(1.shl(n + 1) - 1) { Int.MAX_VALUE }
    dp[0] = 0
    fun study(course: Int): Int {
        if (dp[course] == Int.MAX_VALUE) {
            var bits = course
            while (bits != 0) {
                if (Integer.bitCount(bits) <= k) {
                    val cur = (1..n).filter { 1.shl(it).and(bits) != 0 }
                    if (cur.all { degree[it] == 0 }) {
                        for (c in cur)
                            adj[c].forEach { degree[it]-- }
                        dp[course] = minOf(dp[course], study(course xor bits) + 1)
                        for (c in cur)
                            adj[c].forEach { degree[it]++ }
                    }
                }
                bits = course.and(bits - 1)
            }
        }
        return dp[course]
    }
    return study(1.shl(n + 1) - 2)
}
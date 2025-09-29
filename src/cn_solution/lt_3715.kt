package cn_solution

class Solution_3715 {

    companion object {
        val core = IntArray(100001)

        init {
            for (i in 1 until core.size)
                if (core[i] == 0) {
                    var j = 1
                    while (i * j * j < core.size) {
                        core[i * j * j] = i
                        j++
                    }
                }
        }
    }

    fun sumOfAncestors(n: Int, edges: Array<IntArray>, nums: IntArray): Long {

        val g = Array(n) { ArrayList<Int>() }
        for ((u, v) in edges) {
            g[u].add(v)
            g[v].add(u)
        }
        val cnt = IntArray(100001)
        fun dfs(u: Int, p: Int): Long {
            val c = core[nums[u]]
            var ans = 0L + cnt[c]
            cnt[c]++
            for (v in g[u])
                if (v != p)
                    ans += dfs(v, u)
            cnt[c]--
            return ans
        }
        return dfs(0, -1)
    }
}
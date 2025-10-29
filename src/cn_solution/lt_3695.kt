package cn_solution

fun maxAlternatingSum(nums: IntArray, swaps: Array<IntArray>): Long {
    val n = nums.size
    val g = Array(n) { ArrayList<Int>() }
    for ((u, v) in swaps) {
        g[u].add(v)
        g[v].add(u)
    }
    val vis = BooleanArray(n)
    val cnt = IntArray(2)
    val set = ArrayList<Int>()
    fun dfs(u: Int) {
        vis[u] = true
        cnt[u % 2]++
        set.add(nums[u])
        for (v in g[u])
            if (!vis[v])
                dfs(v)
    }

    var ans = 0L
    for (i in 0 until n)
        if (!vis[i]) {
            cnt.fill(0)
            set.clear()
            dfs(i)
            set.sort()
            for (i in set.indices)
                ans += if (i < cnt[1]) -set[i] else set[i]
        }
    return ans
}
package cn_solution

import kotlin.math.abs

fun minimumHammingDistance_unionFind(source: IntArray, target: IntArray, allowedSwaps: Array<IntArray>): Int {
    val n = source.size
    val p = IntArray(n) { it }
    fun find(x: Int): Int {
        if (p[x] != x)
            p[x] = find(p[x])
        return p[x]
    }
    for ((a, b) in allowedSwaps)
        p[find(a)] = find(b)
    val map = HashMap<Int, HashMap<Int, Int>>()
    for (i in source.indices) {
        val m = map.computeIfAbsent(find(i)) { HashMap() }
        if (source[i] == target[i])
            continue
        m.merge(source[i], 1, Int::plus)
        m.merge(target[i], -1, Int::plus)
    }
    return map.values.sumOf { it.values.sumOf(::abs) / 2 }
}

fun minimumHammingDistance_dfs(source: IntArray, target: IntArray, allowedSwaps: Array<IntArray>): Int {
    val n = source.size
    val g = Array(n) { ArrayList<Int>() }
    for ((a, b) in allowedSwaps) {
        g[a].add(b)
        g[b].add(a)
    }
    val vis = BooleanArray(n)
    val map = HashMap<Int, Int>()
    var ans = 0
    fun dfs(x: Int) {
        vis[x] = true
        if (source[x] != target[x]) {
            map.merge(source[x], 1, Int::plus)
            map.merge(target[x], -1, Int::plus)
        }
        for (y in g[x])
            if (!vis[y])
                dfs(y)
    }
    for (i in 0 until n)
        if (!vis[i]) {
            map.clear()
            dfs(i)
            ans += map.values.sumOf(::abs)
        }
    return ans / 2
}
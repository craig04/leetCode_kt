package cn_solution

private fun minCost(s: String, cost: IntArray): Long {
    val map = LongArray(26)
    var sum = 0L
    for (i in s.indices) {
        map[s[i] - 'a'] += cost[i]
        sum += cost[i]
    }
    return sum - map.max()
}
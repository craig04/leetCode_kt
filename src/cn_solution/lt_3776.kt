package cn_solution

private fun minMoves(balance: IntArray): Long {
    var pos = -1
    var sum = 0L
    for (i in balance.indices) {
        if (balance[i] < 0)
            pos = i
        sum += balance[i]
    }
    when {
        pos == -1 -> return 0
        sum < 0 -> return -1
    }
    val n = balance.size
    var dis = 1
    var ans = 0L
    while (balance[pos] < 0) {
        val i = (pos - dis + n) % n
        val j = (pos + dis) % n
        val cnt = minOf(-balance[pos], balance[i] + balance[j])
        ans += 1L * cnt * dis++
        balance[pos] += cnt
    }
    return ans
}
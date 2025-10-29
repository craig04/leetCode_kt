package cn_solution

fun countStableSubarrays(capacity: IntArray): Long {
    val map = HashMap<Pair<Int, Long>, Int>()
    var ans = 0L
    var sum = 0L
    for (i in 1 until capacity.size) {
        val pre = capacity[i - 1]
        val cur = capacity[i]
        sum += pre
        ans += map[Pair(cur, sum - cur)] ?: 0
        map.merge(Pair(pre, sum), 1, Int::plus)
    }
    return ans
}
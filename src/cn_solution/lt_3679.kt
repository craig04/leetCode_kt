package cn_solution

fun minArrivalsToDiscard(arrivals: IntArray, w: Int, m: Int): Int {
    val map = HashMap<Int, Int>()
    var ans = 0
    for (i in arrivals.indices) {
        val t = arrivals[i]
        val cnt = map[t] ?: 0
        if (cnt == m) {
            ans++
            arrivals[i] = 0
        } else
            map[t] = cnt + 1
        val j = i - w + 1
        if (j >= 0)
            map.merge(arrivals[j], -1, Int::plus)
    }
    return ans
}
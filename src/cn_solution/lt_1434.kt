package cn_solution

const val MOD = 1e9.toInt() + 7

fun numberWays(hats: List<List<Int>>): Int {
    val map = HashMap<Int, ArrayList<Int>>()
    hats.forEachIndexed { index, list ->
        list.forEach {
            map.getOrPut(it - 1) { ArrayList() }.add(index)
        }
    }
    val max = map.keys.maxOrNull()!!
    val dist = Array(max + 1) { map[it]?.toIntArray() ?: intArrayOf() }
    val dp = Array(dist.size) { HashMap<Int, Int>() }
    return calc(dist, 0, 1.shl(hats.size) - 1, 0, dp)
}

private fun calc(dist: Array<IntArray>, n: Int, upper: Int, hasHat: Int, dp: Array<HashMap<Int, Int>>): Int {
    if (upper == hasHat) {
        return 1
    } else if (n == dist.size) {
        return 0
    }
    return dp[n].getOrPut(hasHat) {
        (calc(dist, n + 1, upper, hasHat, dp) + dist[n].fold(0) { r, p ->
            val next = hasHat or (1 shl p)
            if (next == hasHat) {
                r
            } else {
                (r + calc(dist, n + 1, upper, next, dp)) % MOD
            }
        }) % MOD
    }
}

package cn_solution

fun maximumCoins(coins: Array<IntArray>, k: Int): Long {
    fun calculate(): Long {
        var left = 0
        var cur = 0L
        var ans = 0L
        for (right in coins.indices) {
            val (u, v, w) = coins[right]
            cur += (v - u + 1L) * w
            val leftmost = v - k + 1L
            while (coins[left][1] < leftmost) {
                val (x, y, z) = coins[left++]
                cur -= (y - x + 1L) * z
            }
            val coin = coins[left]
            ans = maxOf(ans, cur - maxOf(0, (leftmost - coin[0])) * coin[2])
        }
        return ans
    }
    coins.sortBy { it[0] }
    val res = calculate()
    for (coin in coins) {
        val tmp = -coin[0]
        coin[0] = -coin[1]
        coin[1] = tmp
    }
    coins.reverse()
    return maxOf(res, calculate())
}
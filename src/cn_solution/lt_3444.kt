package cn_solution

fun minimumIncrements(nums: IntArray, target: IntArray): Int {
    fun gcd(x: Long, y: Long): Long = if (y == 0L) x else gcd(y, x % y)
    fun lcm(x: Long, y: Long): Long = x * y / gcd(x, y)
    val n = target.size
    val m = 1 shl n
    val lcm = LongArray(m) {
        var res = 1L
        for (i in 0 until n)
            if (1 shl i and it != 0)
                res = lcm(res, target[i] + 0L)
        res
    }
    val dp = LongArray(m) { 1L shl 32 }
    dp[0] = 0
    for (num in nums) {
        for (x in m - 1 downTo 0) {
            var y = x
            while (y != 0) {
                val l = lcm[y]
                dp[x] = minOf(dp[x], dp[x xor y] + (l - num % l) % l)
                y = (y - 1) and x
            }
        }
    }
    return dp[m - 1].toInt()
}
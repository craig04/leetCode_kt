package cn_solution

fun findKthSmallest(coins: IntArray, k: Int): Long {
    fun gcd(a: Long, b: Long): Long = if (b == 0L) a else gcd(b, a % b)
    fun lcm(a: Long, b: Long): Long = a * b / gcd(a, b)
    fun check(number: Long): Long {
        return (1 until 1.shl(coins.size)).sumOf { bit ->
            val lcm = coins.indices.fold(1L) { lcm, i ->
                if (bit and 1.shl(i) != 0) lcm(lcm, coins[i].toLong()) else lcm
            }
            val cnt = number / lcm
            if (bit.countOneBits().and(1) == 1) cnt else -cnt
        }
    }

    var l = 1L
    var r = 1L * coins.min() * k
    while (l != r) {
        val m = (r - l) / 2 + l
        val order = check(m)
        if (order < k)
            l = m + 1
        else
            r = m
    }
    return l
}
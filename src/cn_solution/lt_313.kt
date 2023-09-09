package cn_solution

fun nthSuperUglyNumber(n: Int, primes: IntArray): Int {
    val ugly = LongArray(n + 1)
    val pos = IntArray(primes.size)
    val num = LongArray(primes.size) { 1 }
    repeat(n) {
        val next = num.min()
        ugly[it + 1] = next
        for (i in num.indices)
            if (num[i] == next)
                num[i] = ugly[++pos[i]] * primes[i]
    }
    return ugly[n].toInt()
}
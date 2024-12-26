package cn_solution

private val MOD = 1000000007
private val f = LongArray(100001).also {
    it[0] = 1
    for (i in 1..100000)
        it[i] = (it[i - 1] * i) % MOD
}

fun countGoodArrays(n: Int, m: Int, k: Int): Int {
    fun pow(x: Long, p: Int): Long {
        var ans = 1L
        var y = x
        var t = p
        while (t > 0) {
            if (t and 1 == 1)
                ans = (ans * y) % MOD
            y = (y * y) % MOD
            t = t shr 1
        }
        return ans
    }

    var ans = pow(m - 1L, n - k - 1) * m % MOD
    ans = (ans * f[n - 1]) % MOD
    ans = (ans * pow(f[k] * f[n - 1 - k] % MOD, MOD - 2)) % MOD
    return ans.mod(MOD)
}
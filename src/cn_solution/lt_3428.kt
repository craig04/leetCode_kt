package cn_solution

class Solution_3428 {

    companion object {

        private const val MOD = 1000000007
        private const val N = 100001
        private val fac = LongArray(N)
        private val inv = LongArray(N)

        init {
            fac[0] = 1
            for (i in 1 until N)
                fac[i] = fac[i - 1] * i % MOD
            inv[N - 1] = 1
            var t = MOD - 2
            var y = fac[N - 1]
            while (t != 0) {
                if (t and 1 == 1)
                    inv[N - 1] = (inv[N - 1] * y) % MOD
                y = y * y % MOD
                t = t shr 1
            }
            for (i in N - 2 downTo 0)
                inv[i] = inv[i + 1] * (i + 1) % MOD
        }
    }

    fun minMaxSums(nums: IntArray, k: Int): Int {
        val n = nums.size
        var s = 1L
        var ans = 0L
        nums.sort()
        for (i in nums.indices) {
            ans = (ans + s * (nums[i] + nums[n - i - 1])) % MOD
            s *= 2
            if (i >= k - 1)
                s += MOD - fac[i] * inv[k - 1] % MOD * inv[i - k + 1] % MOD
            s %= MOD
        }
        return ans.mod(MOD)
    }
}
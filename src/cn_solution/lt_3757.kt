package cn_solution

class Solution_3757 {

    companion object {

        const val MOD = 1000000007
        val pow = IntArray(100001)

        init {
            pow[0] = 1
            for (i in 1 until pow.size)
                pow[i] = pow[i - 1] * 2 % MOD
        }
    }

    fun countEffective(nums: IntArray): Int {
        val max = nums.reduce(Int::or)
        val w = 32 - max.countLeadingZeroBits()
        val u = 1 shl w
        val dp = IntArray(u)
        dp[0] = 1
        for (num in nums)
            dp[num] += 2
        for (i in 0 until w) {
            val t = 1 shl i
            var j = t
            while (j < u) {
                dp[j] += dp[j xor t]
                j = (j + 1) or t
            }
        }
        var ans = pow[nums.size]
        var i = max
        do {
            val d = i.xor(max).countOneBits()
            ans += if (d % 2 == 0) MOD - pow[dp[i]] else pow[dp[i]]
            ans %= MOD
            i = (i - 1) and max
        } while (i != max)
        return ans
    }
}
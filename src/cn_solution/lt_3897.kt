package cn_solution

class Solution_3897 {

    companion object {

        const val MAX = 10001
        const val MOD = 1000000007
        val pow = IntArray(MAX)

        init {
            pow[0] = 1
            for (i in 1 until MAX)
                pow[i] = pow[i - 1] * 2 % MOD
        }
    }

    fun maxValue(nums1: IntArray, nums0: IntArray): Int {
        val nums = Array(nums0.size) { intArrayOf(nums1[it], nums0[it]) }
        nums.sortWith { (a1, a0), (b1, b0) ->
            when {
                a0 == 0 && b0 != 0 -> -1
                a0 != 0 && b0 == 0 -> 1
                a1 == b1 -> a0 - b0
                else -> b1 - a1
            }
        }
        return nums.fold(0L) { ans, (x, y) -> ((ans + 1) * pow[x] - 1) % MOD * pow[y] % MOD }.mod(MOD)
    }
}
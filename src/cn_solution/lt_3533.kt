package cn_solution

fun concatenatedDivisibility(nums: IntArray, k: Int): IntArray {
    val n = nums.size
    val len = IntArray(n) { nums[it].toString().length }
    val mod = IntArray(10)
    mod[0] = 1 % k
    for (i in 1 until mod.size)
        mod[i] = (mod[i - 1] * 10) % k
    val dp = Array(1 shl n) { Array<ArrayList<Int>?>(k) { null } }
    dp[0][0] = arrayListOf()
    for (s in 1 until dp.size) {
        var bits = s
        while (bits != 0) {
            val lowBit = bits.takeLowestOneBit()
            val i = lowBit.countTrailingZeroBits()
            bits = bits xor lowBit
            val t = s xor lowBit
            for (x in 0 until k) {
                val pre = dp[t][x] ?: continue
                val new = ArrayList(pre)
                new.add(nums[i])
                val y = ((x * mod[len[i]]) % k + nums[i] % k) % k
                fun update(): Boolean {
                    val cur = dp[s][y] ?: return true
                    for (i in cur.indices)
                        if (new[i] != cur[i])
                            return new[i] < cur[i]
                    return false
                }
                if (update())
                    dp[s][y] = new
            }
        }
    }
    return (dp.last().first() ?: emptyList()).toIntArray()
}
package cn_solution

fun maximizeXorAndXor(nums: IntArray): Long {
    val n = nums.size
    val m = 1 shl n
    val xor = IntArray(m)
    val and = IntArray(m)
    and[0] = -1
    for (i in 1 until m) {
        val lb = i.takeLowestOneBit()
        val num = nums[lb.countTrailingZeroBits()]
        val j = i xor lb
        xor[i] = xor[j] xor num
        and[i] = and[j] and num
    }
    and[0] = 0
    var ans = 0L
    val b = IntArray(31)
    for (i in 0 until m) {
        var j = (m - 1) xor i
        val odd = xor[j]
        b.fill(0)
        while (j != 0) {
            val lb = j.takeLowestOneBit()
            var num = nums[lb.countTrailingZeroBits()] and odd.inv()
            while (num != 0) {
                val hb = 31 - num.countLeadingZeroBits()
                if (b[hb] == 0) {
                    b[hb] = num
                    break
                }
                num = num xor b[hb]
            }
            j = j xor lb
        }
        var even = 0
        for (i in 30 downTo 0)
            even = maxOf(even, even xor b[i])
        ans = maxOf(ans, even * 2L + odd + and[i])
    }
    return ans
}
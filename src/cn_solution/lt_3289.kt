package cn_solution

fun getSneakyNumbers(nums: IntArray): IntArray {
    val n = nums.size - 2
    var x = nums[n] xor nums[n + 1]
    for (i in 0 until n)
        x = x xor i xor nums[i]
    val cnt = x.countTrailingZeroBits()
    val ans = IntArray(2)
    fun xor(m: Int) {
        val i = m.shr(cnt).and(1)
        ans[i] = ans[i] xor m
    }
    for (i in nums.indices) {
        xor(nums[i])
        if (i < n)
            xor(i)
    }
    return ans
}
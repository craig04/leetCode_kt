package cn_solution

fun canDistribute(nums: IntArray, quantity: IntArray): Boolean {
    val map = HashMap<Int, Int>()
    for (num in nums)
        map.merge(num, 1, Int::plus)
    val cnt = map.values.toIntArray()
    val m = 1 shl quantity.size
    val sums = IntArray(m) {
        var bit = it
        var res = 0
        while (bit != 0) {
            res += quantity[bit.countTrailingZeroBits()]
            bit = bit and (bit - 1)
        }
        res
    }
    val dp = BooleanArray(m)
    dp[0] = true
    for (c in cnt) {
        for (j in m - 1 downTo 0) {
            var k = j
            do {
                if (c >= sums[k] && dp[j xor k]) {
                    dp[j] = true
                    break
                }
                k = (k - 1) and j
            } while (k != j)
        }
    }
    return dp[m - 1]
}
package cn_solution

private fun maxSubarraySum(nums: IntArray, k: Int): Long {
    fun solve(mul: Boolean): Long {
        var (a, b, c) = LongArray(3)
        var ans = Long.MIN_VALUE
        for (num in nums) {
            val x = num + 0L
            c = maxOf(b, c) + num
            b = maxOf(a, b, 0) + if (mul) x * k else x / k
            a = maxOf(a, 0) + num
            ans = maxOf(ans, b, c)
        }
        return ans
    }
    return maxOf(solve(true), solve(false))
}
package cn_solution

private fun maxSubarraySum(nums: IntArray, k: Int): Long {
    val pre = LongArray(k) { Long.MAX_VALUE shr 1 }
    pre[k - 1] = 0
    var ans = Long.MIN_VALUE
    var sum = 0L
    nums.forEachIndexed { i, num ->
        sum += num
        val t = i % k
        ans = maxOf(ans, sum - pre[t])
        pre[t] = minOf(pre[t], sum)
    }
    return ans
}
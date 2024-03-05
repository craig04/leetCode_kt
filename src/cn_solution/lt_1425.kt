package cn_solution

fun constrainedSubsetSum(nums: IntArray, k: Int): Int {
    val dp = IntArray(nums.size)
    val q = ArrayDeque<Int>()
    q.add(Int.MIN_VALUE)
    return nums.indices.maxOf { i ->
        val num = nums[i]
        dp[i] = maxOf(0, q.first()) + num
        while (q.lastOrNull()?.let { it < maxOf(0, q.first()) + num } == true)
            q.removeLast()
        q.addLast(dp[i])
        if (i >= k)
            if (q.first() == dp[i - k])
                q.removeFirst()
        dp[i]
    }
}
package cn_solution

private fun minOperations(nums: IntArray, k: Int): Int {
    val n = nums.size
    if (k > n / 2)
        return -1
    var cnt = 0
    for (i in 1 until n - 1)
        if (nums[i] > maxOf(nums[i - 1], nums[i + 1]))
            cnt++
    if (cnt >= k)
        return 0
    fun solve(a: IntArray): Int {
        var pre = IntArray(a.size)
        var cur = IntArray(a.size)
        repeat(k) {
            cur[0] = Int.MAX_VALUE / 2
            cur[1] = cur[0]
            for (j in 2 until a.size)
                cur[j] = minOf(
                    cur[j - 1],
                    pre[j - 2] + maxOf(a[j - 1], a[j - 2] + 1, a[j] + 1) - a[j - 1]
                )
            val tmp = cur
            cur = pre
            pre = tmp
        }
        return pre.last()
    }

    val x = IntArray(n + 1)
    x[0] = nums[n - 1]
    nums.copyInto(x, 1, 0, n)
    val y = IntArray(n + 1)
    nums.copyInto(y, 0, 0, n)
    y[n] = nums[0]
    return minOf(solve(x), solve(y))
}
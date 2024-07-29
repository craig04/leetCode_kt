package cn_solution

private fun countOfPairs(nums: IntArray): Int {
    val modulo = 1000000007
    val max = nums.max()
    var pre = IntArray(max + 1) { minOf(it, nums[0]) + 1 }
    var cur = IntArray(max + 1)
    for (i in 1 until nums.size) {
        cur.fill(0)
        for (a in maxOf(0, nums[i] - nums[i - 1])..nums[i])
            cur[a] = pre[minOf(a, nums[i - 1] - nums[i] + a)]
        for (a in 1 until cur.size)
            cur[a] = (cur[a] + cur[a - 1]) % modulo
        val tmp = pre
        pre = cur
        cur = tmp
    }
    return pre[max]
}
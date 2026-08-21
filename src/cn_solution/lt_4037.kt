package cn_solution

private fun maxValidSplits(nums: IntArray): Int {
    fun gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
    val n = nums.size
    val pre = IntArray(n + 1)
    val suf = IntArray(n + 1)
    fun solve(a: IntArray): Int {
        suf[a.size] = 0
        for (i in a.indices.reversed())
            suf[i] = gcd(a[i], suf[i + 1])
        return a.indices.count { i ->
            pre[i + 1] = gcd(a[i], pre[i])
            pre[i + 1] == suf[i + 1]
        }
    }

    val ans = solve(nums)
    val del = nums.indices.filter { gcd(pre[it], suf[it + 1]) != suf[0] }
    if (del.size != 1)
        return ans
    val pos = del[0]
    val sub = IntArray(n - 1)
    nums.copyInto(sub, 0, 0, pos)
    nums.copyInto(sub, pos, pos + 1, n)
    return solve(sub)
}
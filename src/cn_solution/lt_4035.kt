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
        var gcd = 0
        var res = 0
        for (i in a.indices) {
            gcd = gcd(a[i], gcd)
            if (gcd == suf[i + 1])
                res++
            pre[i + 1] = gcd
        }
        return res
    }

    val ans = solve(nums)
    var pos = -1
    for (i in nums.indices)
        if (gcd(pre[i], suf[i + 1]) != suf[0]) {
            if (pos != -1)
                return ans
            pos = i
        }
    if (pos == -1)
        return ans
    val sub = IntArray(n - 1)
    nums.copyInto(sub, 0, 0, pos)
    nums.copyInto(sub, pos, pos + 1, n)
    return solve(sub)
}
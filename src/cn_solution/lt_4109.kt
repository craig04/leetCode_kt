package cn_solution

private fun countSuffix(nums: IntArray, target: IntArray): IntArray {
    val n = nums.size
    val m = target.size
    val a = nums + -1 + target
    val z = IntArray(n + m + 1)
    var l = 0
    var r = 0
    for (i in 1 until z.size) {
        if (i <= r)
            z[i] = minOf(z[i - l], r - i + 1)
        while (i + z[i] < a.size && a[i + z[i]] == a[z[i]])
            z[i]++
        if (i + z[i] - 1 > r) {
            l = i
            r = i + z[i] - 1
        }
    }
    val desc = IntArray(m) { 1 }
    for (i in 1 until m)
        if (target[i - 1] >= target[i])
            desc[i] += desc[i - 1]
    val diff = IntArray(100001)
    var cnt = 0
    for (num in nums)
        if (diff[num]-- == 0)
            cnt++
    val ans = IntArray(m - n + 1)
    for (r in target.indices) {
        if (++diff[target[r]] == 0)
            cnt--
        if (r < n - 1)
            continue
        val l = r - n + 1
        if (cnt == 0) {
            val max = minOf(n - 1, z[l + n + 1])
            val min = maxOf(0, n - desc[r])
            ans[r - n + 1] = maxOf(0, max - min + 1)
        }
        if (diff[target[r - n + 1]]-- == 0)
            cnt++
    }
    return ans
}
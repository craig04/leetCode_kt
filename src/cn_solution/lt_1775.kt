package cn_solution

private fun minOperations(nums1: IntArray, nums2: IntArray): Int {
    val n = nums1.size
    val m = nums2.size
    if (n * 6 < m || m * 6 < n)
        return -1
    val a1 = IntArray(7)
    val a2 = IntArray(7)
    var diff = 0
    for (x in nums1) {
        diff += x
        a1[x]++
    }
    for (x in nums2) {
        diff -= x
        a2[x]++
    }
    fun help(c1: IntArray, c2: IntArray): Int {
        var ans = 0
        for (i in 1..5) {
            val dec = 6 - i
            val have = c1[i] + c2[7 - i]
            val take = minOf((diff + dec - 1) / dec, have)
            ans += take
            diff -= take * dec
            if (diff <= 0)
                break
        }
        return ans
    }
    if (diff == 0)
        return 0
    if (diff > 0)
        return help(a2, a1)
    diff = -diff
    return help(a1, a2)
}
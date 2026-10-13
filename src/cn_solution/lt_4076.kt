package cn_solution

private fun resilientSubarray(nums: IntArray, k: Int): Int {
    var ans = 1
    var len = 0
    var pre = -1
    for (x in nums) {
        val cur = x % k
        if (cur != pre)
            len = 0
        len++
        pre = cur
        if (cur * (len - 1) % k == 0)
            ans = maxOf(ans, len)
    }
    return ans
}
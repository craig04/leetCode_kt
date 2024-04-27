package cn_solution

fun maximumScore(nums: IntArray, multipliers: IntArray): Int {
    val n = multipliers.size
    val m = nums.size
    var pre = IntArray(n + 1)
    var cur = IntArray(n + 1)
    for (i in 1..n) {
        val multi = multipliers[i - 1]
        cur[0] = pre[0] + multi * nums[m - i]
        for (j in 1 until i)
            cur[j] = maxOf(
                pre[j] + multi * nums[m - i + j],
                pre[j - 1] + multi * nums[j - 1]
            )
        cur[i] = pre[i - 1] + multi * nums[i - 1]
        val tmp = pre
        pre = cur
        cur = tmp
    }
    return pre.max()
}
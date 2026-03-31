package cn_solution

fun minAbsoluteDifference(nums: IntArray): Int {
    val pos = intArrayOf(-100, -100)
    var ans = 100
    for (i in nums.indices) {
        val x = nums[i] - 1
        if (x >= 0) {
            ans = minOf(ans, i - pos[1 - x])
            pos[x] = i
        }
    }
    return if (ans >= 100) -1 else ans
}
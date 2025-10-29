package cn_solution

private fun minimumDistance(nums: IntArray): Int {
    val map = HashMap<Int, IntArray>()
    var ans = Int.MAX_VALUE
    for (i in nums.indices) {
        val pos = map.computeIfAbsent(nums[i]) { intArrayOf(-1, -1) }
        if (pos[0] != -1)
            ans = minOf(ans, i - pos[0])
        pos[0] = pos[1]
        pos[1] = i
    }
    return if (ans == Int.MAX_VALUE) -1 else ans * 2
}
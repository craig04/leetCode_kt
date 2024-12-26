package cn_solution

fun numberOfSubsequences(nums: IntArray): Long {
    val cnt = HashMap<Double, Int>()
    val n = nums.size
    var ans = 0L
    for (r in 4 until n - 2) {
        val q = r - 2
        for (p in 0..r - 4)
            cnt.merge(1.0 * nums[p] / nums[q], 1, Int::plus)
        for (s in r + 2 until n)
            ans += cnt[1.0 * nums[s] / nums[r]] ?: 0
    }
    return ans
}
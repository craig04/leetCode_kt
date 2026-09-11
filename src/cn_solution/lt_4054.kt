package cn_solution

private fun shadowPairs(nums: IntArray): Long {
    val s = arrayListOf(intArrayOf(0, 0))
    var cnt = 0
    var ans = 0L
    for (x in nums) {
        while (s.last()[0] > x)
            cnt -= s.removeLast()[1]
        ans += cnt++
        if (s.last()[0] == x) {
            ans -= s.last()[1]
            s.last()[1]++
        } else {
            s += intArrayOf(x, 1)
        }
    }
    return ans
}
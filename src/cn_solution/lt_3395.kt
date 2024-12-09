package cn_solution

fun subsequencesWithMiddleMode(nums: IntArray): Int {
    fun quick(x: Int) = x * (x - 1) / 2L
    val n = nums.size
    var ans = (n downTo n - 4L).reduce(Long::times) / 120
    val pre = HashMap<Int, Int>()
    val suf = HashMap<Int, Int>()
    for (num in nums)
        suf.merge(num, 1, Int::plus)
    for (left in 0 until nums.size - 2) {
        val right = n - 1 - left
        val x = nums[left]
        suf.merge(x, -1, Int::plus)
        val preX = pre[x] ?: 0
        val sufX = suf[x] ?: 0
        if (left >= 2) {
            ans -= quick(left - preX) * quick(right - sufX)
            for ((y, sufY) in suf) {
                if (x == y)
                    continue
                val preY = pre[y] ?: 0
                ans -= quick(preY) * sufX * (right - sufX)
                ans -= preX * (left - preX) * quick(sufY)
                ans -= preY * sufY * preX * (right - sufX - sufY)
                ans -= preY * sufY * (left - preX - preY) * sufX
            }
        }
        pre.merge(x, 1, Int::plus)
    }
    return ans.mod(1000000007)
}
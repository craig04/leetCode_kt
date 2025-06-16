package cn_solution

fun specialTriplets(nums: IntArray): Int {
    val suf = HashMap<Int, Int>()
    for (i in nums.indices.reversed())
        suf.merge(nums[i], 1, Int::plus)
    val pre = HashMap<Int, Int>()
    var ans = 0L
    for (num in nums) {
        val x = num * 2
        suf.merge(num, -1, Int::plus)
        ans += 1L * (pre[x] ?: 0) * (suf[x] ?: 0)
        pre.merge(num, 1, Int::plus)
    }
    return ans.mod(1000000007)
}
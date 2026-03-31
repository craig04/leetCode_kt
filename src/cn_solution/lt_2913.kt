package cn_solution

fun sumCounts(nums: List<Int>): Int {
    val modulo = 1000000007
    var ans = 0L
    for (i in nums.indices) {
        val set = HashSet<Int>()
        for (j in i until nums.size) {
            set += nums[j]
            val n = set.size
            ans = (ans + 1L * n * n) % modulo
        }
    }
    return ans.mod(modulo)
}
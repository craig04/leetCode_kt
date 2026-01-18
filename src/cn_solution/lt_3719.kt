package cn_solution

fun longestBalanced(nums: IntArray): Int {
    val s = Array(2) { HashSet<Int>() }
    var ans = 0
    for (i in nums.indices) {
        s[0].clear()
        s[1].clear()
        for (j in i until nums.size) {
            s[nums[j] % 2] += nums[j]
            if (s[0].size == s[1].size)
                ans = maxOf(ans, j - i + 1)
        }
    }
    return ans
}
package cn_solution

fun beautifulSplits(nums: IntArray): Int {
    val n = nums.size
    val lcp = Array(n + 1) { IntArray(n + 1) }
    for (i in n - 1 downTo 0)
        for (j in n - 1 downTo 0)
            if (nums[i] == nums[j])
                lcp[i][j] = lcp[i + 1][j + 1] + 1
    var ans = 0
    for (i in 1 until n - 1)
        for (j in i + 1 until n) {
            if (j - i >= i && lcp[0][i] >= i || lcp[i][j] >= j - i)
                ans++
        }
    return ans
}
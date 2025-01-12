package cn_solution

private fun resultArray(nums: IntArray): IntArray {
    val n = nums.size
    val ans = IntArray(n)
    var i = 0
    var j = n - 1
    ans[i] = nums[0]
    ans[j] = nums[1]
    for (k in 2 until n)
        if (ans[i] > ans[j])
            ans[++i] = nums[k]
        else
            ans[--j] = nums[k]
    ans.reverse(j, n)
    return ans
}
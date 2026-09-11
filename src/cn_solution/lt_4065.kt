package cn_solution

private fun rearrangeArray(nums: IntArray): IntArray {
    val ans = IntArray(nums.size)
    var pos = 0
    val cnt = IntArray(101)
    for (num in nums)
        cnt[num]++
    while (pos != ans.size) {
        for (i in cnt.indices)
            if (--cnt[i] >= 0)
                ans[pos++] = i
    }
    return ans
}
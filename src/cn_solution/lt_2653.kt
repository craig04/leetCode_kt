package cn_solution

fun getSubarrayBeauty(nums: IntArray, k: Int, x: Int): IntArray {
    val cnt = IntArray(101)
    val ans = ArrayList<Int>()
    for (i in nums.indices) {
        cnt[nums[i] + 50]++
        if (i >= k - 1) {
            var y = x
            for (j in cnt.indices) {
                y -= cnt[j]
                if (y <= 0) {
                    ans += minOf(j - 50, 0)
                    break
                }
            }
            cnt[nums[i - k + 1] + 50]--
        }
    }
    return ans.toIntArray()
}
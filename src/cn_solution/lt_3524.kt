package cn_solution

fun resultArray(nums: IntArray, k: Int): LongArray {
    val ans = LongArray(k)
    val pre = LongArray(k)
    val cur = LongArray(k)
    for (i in nums.indices) {
        val num = nums[i] % k
        for (j in 0 until k)
            cur[num * j % k] += pre[j]
        cur[num]++
        for (j in 0 until k)
            ans[j] += cur[j]
        cur.copyInto(pre)
        cur.fill(0)
    }
    return ans
}
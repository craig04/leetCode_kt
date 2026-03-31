package cn_solution

fun distance(nums: IntArray): LongArray {
    val map = nums.indices.groupBy { nums[it] }
    val ans = LongArray(nums.size)
    for (a in map.values) {
        val n = a.size
        var sum = a.sumOf { it - a[0] + 0L }
        ans[a[0]] = sum
        for (i in 1 until n) {
            sum += (2L * i - n) * (a[i] - a[i - 1])
            ans[a[i]] = sum
        }
    }
    return ans
}
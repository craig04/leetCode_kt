package cn_solution

fun shortestSubarray(nums: IntArray, k: Int): Int {
    var ans = Int.MAX_VALUE
    var sum = 0L
    val s = LongArray(nums.size + 1)
    val p = IntArray(nums.size + 1)
    s[0] = 0
    p[0] = -1
    var head = 0
    var tail = 0
    for (i in nums.indices) {
        sum += nums[i]
        while (head <= tail && sum - s[head] >= k)
            ans = minOf(ans, i - p[head++])
        while (head <= tail && sum <= s[tail])
            tail--
        s[++tail] = sum
        p[tail] = i
    }
    return if (ans == Int.MAX_VALUE) -1 else ans
}
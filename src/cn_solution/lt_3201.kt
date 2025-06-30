package cn_solution

fun maximumLength(nums: IntArray): Int {
    var ans = 0
    var pre = -1
    val cnt = IntArray(2)
    for (num in nums) {
        val cur = num and 1
        if (cur != pre) {
            pre = cur
            ans++
        }
        cnt[cur]++
    }
    return maxOf(ans, cnt.max())
}
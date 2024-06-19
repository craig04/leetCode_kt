package cn_solution

fun maximumGap(nums: IntArray): Int {
    val n = nums.size
    if (n < 2)
        return 0
    var lower = Int.MAX_VALUE
    var upper = Int.MIN_VALUE
    for (num in nums) {
        lower = minOf(num, lower)
        upper = maxOf(num, upper)
    }
    if (lower == upper)
        return 0
    val gap = (upper - lower + n - 2) / (n - 1)
    val min = IntArray(n) { Int.MAX_VALUE }
    val max = IntArray(n) { Int.MIN_VALUE }
    for (num in nums) {
        val t = (num - lower) / gap
        min[t] = minOf(min[t], num)
        max[t] = maxOf(max[t], num)
    }
    var ans = 0
    var last = Int.MAX_VALUE
    for (i in min.indices) {
        if (min[i] != Int.MAX_VALUE) {
            ans = maxOf(ans, min[i] - last)
            last = max[i]
        }
    }
    return ans
}
package cn_solution

fun longestMonotonicSubarray(nums: IntArray): Int {
    fun lis(a: IntArray): Int {
        var len = 1
        return (1 until a.size).maxOfOrNull {
            if (a[it] <= a[it - 1])
                len = 0
            ++len
        } ?: 1
    }

    val ans = lis(nums)
    nums.reverse()
    return maxOf(ans, lis(nums))
}
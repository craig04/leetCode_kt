package cn_solution

fun maxSumTrionic(nums: IntArray): Long {
    val default = Long.MIN_VALUE / 2
    var (x, y, z) = LongArray(3) { default }
    return (1 until nums.size).maxOf { i ->
        val p = nums[i - 1] + 0L
        val q = nums[i]
        z = if (p < q) maxOf(y, z) + q else default
        y = if (p > q) maxOf(x, y) + q else default
        x = if (p < q) maxOf(p, x) + q else default
        z
    }
}
package cn_solution

fun rob(nums: IntArray, colors: IntArray): Long {
    val n = nums.size
    var x = 0L
    var y = nums[0] + 0L
    for (i in 1 until n) {
        val z = if (colors[i] != colors[i - 1])
            y + nums[i]
        else
            maxOf(x + nums[i], y)
        x = y
        y = z
    }
    return y
}
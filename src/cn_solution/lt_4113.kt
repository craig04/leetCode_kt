package cn_solution

fun maxDifference(nums: IntArray): Long {
    var c = 0L
    var b = 0L + nums.last()
    for (i in nums.size - 2 downTo 0) {
        val x = nums[i]
        val y = x + nums[i + 1]
        val a = maxOf(
            x + if (x % 3 == 0) -b else b,
            y + if (y % 3 == 0) -c else c
        )
        c = b
        b = a
    }
    return b
}
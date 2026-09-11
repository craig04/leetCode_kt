package cn_solution

private fun maxValue(nums: IntArray): Long {
    var sum = 0L + nums.first()
    var a = 0L
    var b = 0L
    var add = 0L
    for (i in 1 until nums.size) {
        val x = nums[i]
        var d = x - nums[i - 1]
        if (i % 2 == 0) {
            sum += x
            d = -d
        } else
            sum -= x
        val c = maxOf(a, 0) + d
        a = b
        b = c
        add = maxOf(add, c)
    }
    return sum + 2 * add
}
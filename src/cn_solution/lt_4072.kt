package cn_solution

private fun maxAlternatingSum(nums: IntArray): Long {
    val a = LongArray(4) { Long.MIN_VALUE / 2 }
    val b = LongArray(4)
    return nums.maxOf { x ->
        b[0] = maxOf(0, a[1]) + x
        b[1] = a[0] - x
        b[2] = maxOf(a[0], a[3] + x)
        b[3] = maxOf(a[1], a[2] - x)
        b.copyInto(a)
        a.max()
    }
}
package cn_solution

fun maximumTotalCost(nums: IntArray): Long {
    var a = 0L
    var b = 0L
    for (num in nums.asList().asReversed()) {
        val c = a - num
        a = maxOf(a, b) + num
        b = c
    }
    return a
}
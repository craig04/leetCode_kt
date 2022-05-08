package cn_solution

fun smallestRangeI(nums: IntArray, k: Int): Int {
    var min = Int.MAX_VALUE
    var max = Int.MIN_VALUE
    for (n in nums) {
        min = minOf(min, n)
        max = maxOf(max, n)
    }
    return maxOf(0, max - min - 2 * k)
}
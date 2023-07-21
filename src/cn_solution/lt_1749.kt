package cn_solution

fun maxAbsoluteSum(nums: IntArray): Int {
    var max = Int.MIN_VALUE
    var min = Int.MAX_VALUE
    var sum = 0
    for (n in nums) {
        sum += n
        max = maxOf(max, sum)
        min = minOf(min, sum)
    }
    return max - min
}
package cn_solution

fun maximumDifference(nums: IntArray): Int {
    var min = Int.MAX_VALUE
    val ans = nums.maxOf {
        min = minOf(min, it)
        it - min
    }
    return if (ans > 0) ans else -1
}
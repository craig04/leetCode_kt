package cn_solution

fun maxFrequencyElements(nums: IntArray): Int {
    val cnt = IntArray(101)
    val max = nums.maxOf { ++cnt[it] }
    return cnt.count { it == max } * max
}
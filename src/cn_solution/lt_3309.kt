package cn_solution

fun maxGoodNumber(nums: IntArray): Int {
    val s = Array(3) { nums[it].toString(2) }
    s.sortWith { a, b -> (b + a).compareTo(a + b) }
    return s.joinToString("") { it }.toInt(2)
}
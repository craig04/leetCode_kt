package cn_solution

fun maximizeGreatness(nums: IntArray): Int {
    val map = HashMap<Int, Int>()
    return nums.maxOf { map.merge(it, 1, Int::plus) ?: 0 }
}
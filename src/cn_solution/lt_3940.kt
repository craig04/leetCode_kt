package cn_solution

fun limitOccurrences(nums: IntArray, k: Int): IntArray {
    val map = HashMap<Int, Int>()
    return nums.filter { (map.merge(it, 1, Int::plus) ?: 0) <= k }.toIntArray()
}
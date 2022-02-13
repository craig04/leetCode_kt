package cn_solution

fun intersect(nums1: IntArray, nums2: IntArray): IntArray {
    val map = HashMap<Int, Int>()
    nums2.forEach {
        map[it] = (map[it] ?: 0) + 1
    }
    return nums1.filter {
        val count = map[it] ?: 0
        map[it] = count - 1
        count >= 1
    }.toIntArray()
}
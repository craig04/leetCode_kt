package cn_solution

fun twoOutOfThree(nums1: IntArray, nums2: IntArray, nums3: IntArray): List<Int> {
    val map = HashMap<Int, Int>()
    nums1.forEach { map[it] = 1 }
    nums2.forEach { map[it] = (map[it] ?: 0) or 2 }
    nums3.forEach { map[it] = (map[it] ?: 0) or 4 }
    return map.asSequence().filter { it.value.and(it.value - 1) != 0 }.map { it.key }.toList()
}

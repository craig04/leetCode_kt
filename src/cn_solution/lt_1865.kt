package cn_solution

class FindSumPairs(val nums1: IntArray, val nums2: IntArray) {

    val map = nums2.asSequence().groupingBy { it }.eachCountTo(HashMap())

    fun add(index: Int, `val`: Int) {
        map.merge(nums2[index], -1, Int::plus)
        nums2[index] += `val`
        map.merge(nums2[index], 1, Int::plus)
    }

    fun count(tot: Int): Int {
        return nums1.sumOf { map[tot - it] ?: 0 }
    }
}
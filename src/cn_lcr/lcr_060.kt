package cn_lcr

fun topKFrequent(nums: IntArray, k: Int): IntArray {
    val count = HashMap<Int, Int>()
    nums.forEach { count[it] = (count[it] ?: 0) + 1 }
    val sort = count.entries.sortedByDescending { it.value }
    return IntArray(k) { sort[it].key }
}
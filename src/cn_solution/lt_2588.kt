package cn_solution

fun beautifulSubarrays(nums: IntArray): Long {
    val map = hashMapOf(0 to 1L)
    var acc = 0
    return nums.sumOf {
        acc = acc xor it
        val res = map[acc] ?: 0L
        map.merge(acc, 1L, Long::plus)
        res
    }
}
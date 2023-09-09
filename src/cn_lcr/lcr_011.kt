package cn_lcr

fun findMaxLength(nums: IntArray): Int {
    val map = hashMapOf(0 to -1)
    var diff = 0
    var result = 0
    nums.forEachIndexed { i, m ->
        diff += m * 2 - 1
        map.putIfAbsent(diff, i)?.let { j ->
            result = maxOf(result, i - j)
        }
    }
    return result
}
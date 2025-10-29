package cn_solution

fun findMaxLength(nums: IntArray): Int {
    val map = hashMapOf(0 to -1)
    var cnt = 0
    return nums.indices.maxOf { i ->
        if (nums[i] == 0) cnt-- else cnt++
        i - map.computeIfAbsent(cnt) { i }
    }
}
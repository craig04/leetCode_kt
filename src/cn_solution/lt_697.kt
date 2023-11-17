package cn_solution

fun findShortestSubArray(nums: IntArray): Int {
    val map = HashMap<Int, IntArray>()
    for (i in nums.indices) {
        val n = nums[i]
        val a = map.computeIfAbsent(n) { intArrayOf(0, Int.MAX_VALUE, 0) }
        a[0]++
        a[1] = minOf(a[1], i)
        a[2] = i
    }
    var freq = 0
    var length = 0
    for (entry in map) {
        val (f, s, e) = entry.value
        if (f > freq) {
            freq = f
            length = e - s
        } else if (f == freq) {
            length = minOf(length, e - s)
        }
    }
    return length + 1
}
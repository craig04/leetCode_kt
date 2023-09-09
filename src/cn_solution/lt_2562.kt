package cn_solution

fun findTheArrayConcVal(nums: IntArray): Long {
    var result = 0L
    var i = 0
    var j = nums.lastIndex
    val times = arrayOf(10, 100, 1000, 10000, 100000)
    while (i < j) {
        val t = times.first { it > nums[j] }
        result += nums[i++] * t + nums[j--]
    }
    if (i == j)
        result += nums[i]
    return result
}
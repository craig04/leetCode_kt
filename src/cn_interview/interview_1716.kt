package cn_interview

fun massage(nums: IntArray): Int {
    var a = 0
    var b = 0
    for (n in nums) {
        val c = b + n
        b = maxOf(a, b)
        a = c
    }
    return maxOf(a, b)
}
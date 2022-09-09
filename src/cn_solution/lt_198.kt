package cn_solution

private fun rob(nums: IntArray): Int {
    var a = 0
    var b = 0
    for (n in nums) {
        val temp = b + n
        b = maxOf(a, b)
        a = temp
    }
    return maxOf(a, b)
}
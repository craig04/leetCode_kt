package cn_solution

private fun maxProduct(nums: IntArray): Int {
    var a = Int.MIN_VALUE
    var b = a
    for (i in nums.indices) {
        val n = nums[i]
        if (n > a) {
            b = a
            a = n
        } else if (n > b) {
            b = n
        }
    }
    return (a - 1) * (b - 1)
}
package cn_solution

fun maxProduct(nums: IntArray): Int {
    var a = maxOf(nums[0], nums[1])
    var b = nums[0] + nums[1] - a
    for (i in 2 until nums.size) {
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
package cn_solution

fun arraySign(nums: IntArray): Int {
    var result = 1
    for (n in nums) {
        when {
            n == 0 -> return 0
            n < 0 -> result = -result
        }
    }
    return result
}

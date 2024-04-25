package cn_solution

fun maxDivScore(nums: IntArray, divisors: IntArray): Int {
    var count = -1
    var divisor = 0
    for (d in divisors) {
        val c = nums.count { it % d == 0 }
        if (c > count || (c == count && d < divisor)) {
            count = c
            divisor = d
        }
    }
    return divisor
}
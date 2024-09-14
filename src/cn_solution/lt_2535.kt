package cn_solution

fun differenceOfSum(nums: IntArray): Int {
    return nums.sumOf {
        var res = it
        var t = it
        while (t != 0) {
            res -= t % 10
            t /= 10
        }
        res
    }
}
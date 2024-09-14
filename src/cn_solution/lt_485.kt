package cn_solution

fun findMaxConsecutiveOnes(nums: IntArray): Int {
    var len = 0
    return nums.maxOf {
        if (it == 0)
            len = 0
        else
            len++
        len
    }
}
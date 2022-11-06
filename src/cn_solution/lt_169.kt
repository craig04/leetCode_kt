package cn_solution

fun majorityElement(nums: IntArray): Int {
    var count = 0
    var major = Int.MIN_VALUE
    for (n in nums) {
        if (count == 0)
            major = n
        when (major) {
            n -> count++
            else -> count--
        }
    }
    return major
}

package cn_interview

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
    count = nums.count { it == major }
    return if (count > nums.size / 2) major else -1
}
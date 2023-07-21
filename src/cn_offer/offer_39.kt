package cn_offer

fun majorityElement(nums: IntArray): Int {
    var count = 0
    var major = 0
    for (n in nums) {
        if (count == 0)
            major = n
        if (major == n)
            count++
        else
            count--
    }
    return major
}
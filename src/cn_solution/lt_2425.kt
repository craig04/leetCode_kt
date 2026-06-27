package cn_solution

fun xorAllNums(nums1: IntArray, nums2: IntArray): Int {
    var ans = 0
    if (nums1.size % 2 == 1)
        ans = ans xor nums2.reduce(Int::xor)
    if (nums2.size % 2 == 1)
        ans = ans xor nums1.reduce(Int::xor)
    return ans
}
package cn_solution

fun scoreDifference(nums: IntArray): Int {
    val s = IntArray(2)
    var a = 0
    for (i in nums.indices) {
        a = nums[i] and 1 xor a
        if ((i + 1) % 6 == 0)
            a = a xor 1
        s[a] += nums[i]
    }
    return s[0] - s[1]
}
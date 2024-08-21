package cn_solution

fun rearrangeArray(nums: IntArray): IntArray {
    val len = nums.size
    var p = 0
    var n = 0
    val ans = IntArray(len)
    var pos = 0
    do {
        while (p != len && nums[p] < 0)
            p++
        ans[pos++] = nums[p++]
        while (n != len && nums[n] > 0)
            n++
        ans[pos++] = nums[n++]
    } while (p != len)
    return ans
}
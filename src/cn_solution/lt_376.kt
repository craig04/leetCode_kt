package cn_solution

fun wiggleMaxLength(nums: IntArray): Int {
    var ans = 1
    var pre = 0
    for (i in 1 until nums.size) {
        val cur = nums[i - 1].compareTo(nums[i])
        if (cur != 0 && cur != pre) {
            ans++
            pre = cur
        }
    }
    return ans
}
package cn_solution

fun smallestSubarrays(nums: IntArray): IntArray {
    val ans = IntArray(nums.size) { 1 }
    for (i in nums.indices) {
        val num = nums[i]
        for (j in i - 1 downTo 0) {
            val tmp = nums[j] or num
            if (tmp == nums[j])
                break
            nums[j] = tmp
            ans[j] = i - j + 1
        }
    }
    return ans
}
package cn_solution

fun kthLargestNumber(nums: Array<String>, k: Int): String {
    nums.sortWith(compareBy({ it.length }, { it }))
    return nums[nums.size - k]
}
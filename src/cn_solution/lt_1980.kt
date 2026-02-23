package cn_solution

fun findDifferentBinaryString(nums: Array<String>): String {
    return String(CharArray(nums.size) { '0' + ('1' - nums[it][it]) })
}
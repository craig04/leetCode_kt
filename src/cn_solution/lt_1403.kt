package cn_solution

fun minSubsequence(nums: IntArray): List<Int> {
    nums.sortDescending()
    var temp = nums.sum() / 2
    var i = 0
    val result = ArrayList<Int>()
    while (temp >= 0) {
        temp -= nums[i]
        result.add(nums[i++])
    }
    return result
}

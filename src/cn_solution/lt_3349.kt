package cn_solution

fun hasIncreasingSubarrays(nums: List<Int>, k: Int): Boolean {
    var pre = 0
    var i = 0
    while (i != nums.size) {
        var j = i + 1
        while (j != nums.size && nums[j] > nums[j - 1])
            j++
        val cur = j - i
        if (cur / 2 >= k || cur >= k && pre >= k)
            return true
        i = j
        pre = cur
    }
    return false
}
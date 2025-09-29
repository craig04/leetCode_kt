package cn_solution

fun maxIncreasingSubarrays(nums: List<Int>): Int {
    var ans = 0
    var pre = 0
    var i = 0
    while (i != nums.size) {
        var j = i + 1
        while (j != nums.size && nums[j] > nums[j - 1])
            j++
        val cur = j - i
        ans = maxOf(ans, cur / 2, minOf(pre, cur))
        pre = cur
        i = j
    }
    return ans
}
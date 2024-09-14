package cn_solution

fun countAlternatingSubarrays(nums: IntArray): Long {
    val n = nums.size
    var i = 0
    var ans = 0L
    while (i != n) {
        var j = i + 1
        while (j != n && nums[j] != nums[j - 1])
            j++
        val len = j - i
        ans += (1L + len) * len / 2
        i = j
    }
    return ans
}
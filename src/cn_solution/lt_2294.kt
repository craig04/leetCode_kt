package cn_solution

private fun partitionArray(nums: IntArray, k: Int): Int {
    nums.sort()
    val n = nums.size
    var i = 0
    var ans = 0
    while (i != n) {
        var j = i + 1
        while (j != n && nums[j] - nums[i] <= k)
            j++
        i = j
        ans++
    }
    return ans
}
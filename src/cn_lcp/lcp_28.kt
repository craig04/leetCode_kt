package cn_lcp

fun purchasePlans(nums: IntArray, target: Int): Int {
    nums.sort()
    var i = 0
    var j = nums.lastIndex
    var ans = 0L
    while (i < j) {
        if (nums[i] + nums[j] < target)
            ans += j - i++
        else
            j--
    }
    return ans.mod(1000000007)
}
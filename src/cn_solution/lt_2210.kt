package cn_solution

fun countHillValley(nums: IntArray): Int {
    var ans = 0
    var i = 0
    for (j in nums.indices) {
        if (nums[i] == nums[j])
            continue
        if (i != 0 && nums[i - 1] > nums[i] == nums[j] > nums[j - 1])
            ans++
        i = j
    }
    return ans
}
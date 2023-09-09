package cn_lcr

fun threeSum(nums: IntArray): List<List<Int>> {
    val result = ArrayList<List<Int>>()
    nums.sort()
    for (i in nums.indices) {
        if (i != 0 && nums[i] == nums[i - 1])
            continue
        var l = i + 1
        var r = nums.lastIndex
        while (l < r) {
            val sum = nums[l] + nums[r]
            if (sum == -nums[i]) {
                result.add(listOf(nums[i], nums[l], nums[r]))
                while (++l < r && nums[l] == nums[l - 1]) Unit
                while (l < --r && nums[r] == nums[r + 1]) Unit
                continue
            }
            if (sum + nums[i] > 0) r-- else l++
        }
    }
    return result
}
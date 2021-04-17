package solution_cn

class Solution {

    fun rob(nums: IntArray): Int {
        if (nums.size == 1) {
            return nums.first()
        }
        return maxOf(rob(nums, 1, nums.size), rob(nums, 0, nums.lastIndex))
    }

    private fun rob(nums: IntArray, begin: Int, end: Int): Int {
        var yes = 0
        var no = 0
        for (i in begin until end) {
            val temp = maxOf(yes, no)
            yes = no + nums[i]
            no = temp
        }
        return maxOf(yes, no)
    }
}
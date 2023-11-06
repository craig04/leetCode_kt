package cn_lcr

private fun rob(nums: IntArray): Int {
    if (nums.size == 1) {
        return nums.first()
    }
    fun rob(begin: Int, end: Int): Int {
        var yes = 0
        var no = 0
        for (i in begin until end) {
            val temp = maxOf(yes, no)
            yes = no + nums[i]
            no = temp
        }
        return maxOf(yes, no)
    }
    return maxOf(rob(1, nums.size), rob(0, nums.lastIndex))
}
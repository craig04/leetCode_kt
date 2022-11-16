package cn_solution

fun numSubarrayBoundedMax(nums: IntArray, left: Int, right: Int): Int {
    var last1 = -1
    var last2 = -1
    return nums.sumBy {
        val n = nums[it]
        if (n > right) {
            last1 = -1
            last2 = it
        } else if (n >= left) {
            last1 = it
        }
        if (last1 == -1) 0 else last1 - last2
    }
}

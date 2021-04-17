package solution_cn

private fun removeDuplicates(nums: IntArray): Int {
    if (nums.isEmpty()) {
        return 0
    }
    var p = 1
    for (i in 1 until nums.size) {
        if (nums[i] != nums[i - 1]) {
            nums[p++] = nums[i]
        }
    }
    return p
}
package solution_cn

fun removeDuplicates(nums: IntArray): Int {
    var p = minOf(nums.size, 2)
    for (i in 2 until nums.size) {
        if (nums[i] != nums[p - 2]) {
            nums[p++] = nums[i]
        }
    }
    return p
}
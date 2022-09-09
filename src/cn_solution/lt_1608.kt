package cn_solution

fun specialArray(nums: IntArray): Int {
    val n = nums.size
    nums.sortDescending()
    return (1 until n).firstOrNull {
        nums[it - 1] >= it && nums[it] < it
    } ?: if (nums.last() >= n) n else -1
}

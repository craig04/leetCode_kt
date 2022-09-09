package cn_solution

fun sortedSquares(nums: IntArray): IntArray {
    fun Int.sq() = this * this
    val pivot = nums.indexOfFirst { it >= 0 }
    var right = if (pivot == -1) nums.size else pivot
    var left = right - 1
    val result = IntArray(nums.size)
    var index = 0
    while (left != -1 || right != nums.size) {
        result[index++] = when {
            left == -1 -> nums[right++].sq()
            right == nums.size -> nums[left--].sq()
            nums[right] > -nums[left] -> nums[left--].sq()
            else -> nums[right++].sq()
        }
    }
    return result
}
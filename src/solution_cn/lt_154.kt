package solution_cn

private fun findMin(nums: IntArray): Int {
    var left = 0
    var right = nums.size - 1
    loop@ while (left != right) {
        val mid = (left + right) shr 1
        val num = nums[mid]
        when {
            num < nums[right] -> right = mid
            num > nums[right] -> left = mid + 1
            num > nums[left] -> break@loop
            num < nums[left] -> right = mid
            else -> right--
        }
    }
    return nums[left]
}
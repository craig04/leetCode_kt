package cn_interview

fun findMagicIndex(nums: IntArray): Int {
    fun find(left: Int, right: Int): Int {
        if (left > right) {
            return -1
        }
        val mid = (left + right) shr 1
        val index = find(left, mid - 1)
        return when {
            index != -1 -> index
            mid == nums[mid] -> mid
            else -> find(mid + 1, right)
        }
    }
    return find(0, nums.lastIndex)
}
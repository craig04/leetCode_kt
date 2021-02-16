package solution

fun getSumAbsoluteDifferences(nums: IntArray): IntArray {
    val size = nums.size
    val result = IntArray(size)
    result[0] = nums.sumBy { it - nums[0] }
    for (i in (1 until size)) {
        val diff = nums[i] - nums[i - 1]
        result[i] = result[i - 1] - (size - 2 * i) * diff
    }
    return result
}
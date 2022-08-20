package cn_solution

class NumArray_304(nums: IntArray) {

    private val prefix = IntArray(nums.size + 1).also {
        for (i in nums.indices) {
            it[i + 1] = it[i] + nums[i]
        }
    }

    fun sumRange(left: Int, right: Int): Int {
        return prefix[right + 1] - prefix[left]
    }
}
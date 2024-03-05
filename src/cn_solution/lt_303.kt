package cn_solution

class NumArray_303(nums: IntArray) {

    private val pref = IntArray(nums.size + 1)

    init {
        nums.forEachIndexed { i, n -> pref[i + 1] = pref[i] + nums[i] }
    }

    fun sumRange(left: Int, right: Int): Int {
        return pref[right + 1] - pref[left]
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * var obj = NumArray(nums)
 * var param_1 = obj.sumRange(left,right)
 */
package cn_solution

private fun twoSum(nums: IntArray, target: Int): IntArray {
    val map = HashMap<Int, Int>()
    nums.forEachIndexed { index, i ->
        map[target - i]?.run {
            return intArrayOf(this, index)
        }
        map[i] = index
    }
    return IntArray(0)
}
package cn_solution

fun canMakeEqual(nums: IntArray, k: Int): Boolean {
    fun canMake(target: Int): Boolean {
        var pre = 0
        var ops = 0
        for (i in 0 until nums.lastIndex) {
            pre = pre xor nums[i] xor target
            if (pre != 0 && ++ops > k)
                return false
        }
        return pre xor nums.last() == target
    }
    return canMake(1) || canMake(-1)
}
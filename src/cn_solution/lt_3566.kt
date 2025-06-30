package cn_solution

fun checkEqualPartitions(nums: IntArray, target: Long): Boolean {
    val n = nums.size
    val m = 1.shl(n) - 1
    fun product(mask: Int): Boolean {
        var t = target
        for (i in 0 until n)
            if (1 shl i and mask != 0) {
                if (t % nums[i] != 0L)
                    return false
                t /= nums[i]
            }
        return t == 1L
    }
    return (1 until m).any {
        product(it) && product(it xor m)
    }
}
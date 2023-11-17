package cn_lcr

fun subsets(nums: IntArray): List<List<Int>> {
    return (0 until 1.shl(nums.size)).map {
        ArrayList<Int>().apply {
            for (i in nums.indices) {
                if (1.shl(i).and(it) != 0)
                    add(nums[i])
            }
        }
    }
}
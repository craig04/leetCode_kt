package cn_interview

fun subsets(nums: IntArray): List<List<Int>> {
    val result = ArrayList<List<Int>>()
    for (i in 0 until 1.shl(nums.size)) {
        val list = ArrayList<Int>()
        for (j in nums.indices)
            if (1.shl(j).and(i) != 0)
                list.add(nums[j])
        result.add(list)
    }
    return result
}
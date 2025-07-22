package cn_solution

fun countMaxOrSubsets(nums: IntArray): Int {
    val max = nums.reduce(Int::or)
    return (1 until 1.shl(nums.size)).count { bit ->
        var res = 0
        for (j in nums.indices)
            if (1.shl(j).and(bit) != 0)
                res = res or nums[j]
        res == max
    }
}
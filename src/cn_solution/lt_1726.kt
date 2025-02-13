package cn_solution

fun tupleSameProduct(nums: IntArray): Int {
    val map = HashMap<Int, Int>()
    for (i in nums.indices)
        for (j in i + 1 until nums.size)
            map.merge(nums[i] * nums[j], 1, Int::plus)
    return map.values.sumOf { it * (it - 1) } * 4
}
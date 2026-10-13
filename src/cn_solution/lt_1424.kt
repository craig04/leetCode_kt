package cn_solution

fun findDiagonalOrder(nums: List<List<Int>>): IntArray {
    val lines = nums.indices.maxOf { it + nums[it].size }
    val a = Array(lines) { ArrayList<Int>() }
    for (i in nums.indices)
        for (j in nums[i].indices)
            a[i + j] += nums[i][j]
    return a.flatMap { it.asReversed() }.toIntArray()
}
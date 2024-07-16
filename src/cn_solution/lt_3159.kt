package cn_solution

fun occurrencesOfElement(nums: IntArray, queries: IntArray, x: Int): IntArray {
    val pos = arrayListOf(0)
    for (i in nums.indices)
        if (nums[i] == x)
            pos.add(i)
    return IntArray(queries.size) { pos.getOrNull(queries[it]) ?: -1 }
}
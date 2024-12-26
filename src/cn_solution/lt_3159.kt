package cn_solution

fun occurrencesOfElement(nums: IntArray, queries: IntArray, x: Int): IntArray {
    val pos = nums.indices.filterTo(arrayListOf(0)) { nums[it] == x }
    return IntArray(queries.size) { pos.getOrNull(queries[it]) ?: -1 }
}
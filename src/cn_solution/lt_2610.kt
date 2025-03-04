package cn_solution

fun findMatrix(nums: IntArray): List<List<Int>> {
    val map = nums.asSequence().groupingBy { it }.eachCount()
    return Array(map.values.max()) { i ->
        map.asSequence().filter { it.value > i }.map { it.key }.toList()
    }.asList()
}
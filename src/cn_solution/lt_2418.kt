package cn_solution

import java.util.*

fun sortPeople(names: Array<String>, heights: IntArray): Array<String> {
    val indices = Array(heights.size) { it }
    Arrays.sort(indices) { lhs, rhs -> heights[rhs] - heights[lhs] }
    return Array(heights.size) { names[indices[it]] }
}
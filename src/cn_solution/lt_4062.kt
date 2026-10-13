package cn_solution

fun canTransform(source: IntArray, target: IntArray): Boolean {
    return source.indices.sumOf { 0L + source[it] - target[it] } == 0L
}
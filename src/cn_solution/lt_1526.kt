package cn_solution

fun minNumberOperations(target: IntArray): Int {
    return target[0] + (1 until target.size).sumOf { maxOf(0, target[it] - target[it - 1]) }
}
package cn_solution

fun maxContainers(n: Int, w: Int, maxWeight: Int): Int {
    return minOf(n * n, maxWeight / w)
}
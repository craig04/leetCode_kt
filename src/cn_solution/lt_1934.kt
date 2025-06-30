package cn_solution

fun findLucky(arr: IntArray): Int {
    return arr.asSequence()
        .groupingBy { it }
        .eachCount()
        .maxOf { (k, v) -> if (k == v) k else -1 }
}
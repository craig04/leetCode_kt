package cn_solution

fun largestCombination(candidates: IntArray): Int {
    return (0 until 30).maxOf { i ->
        candidates.count { 1 shl i and it != 0 }
    }
}
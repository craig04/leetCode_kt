package cn_solution

fun maximumHappinessSum(happiness: IntArray, k: Int): Long {
    happiness.sortDescending()
    return (0 until k).sumOf { maxOf(happiness[it] - it, 0) + 0L }
}
package cn_solution

fun maxProfitAssignment(difficulty: IntArray, profit: IntArray, worker: IntArray): Int {
    val works = Array(difficulty.size) { Pair(difficulty[it], profit[it]) }
    works.sortBy { it.first }
    worker.sort()
    var pos = -1
    var maxProfit = 0
    return worker.sumOf {
        while (pos != difficulty.lastIndex && works[pos + 1].first <= it) {
            maxProfit = maxOf(maxProfit, works[++pos].second)
        }
        maxProfit
    }
}
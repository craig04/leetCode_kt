package cn_solution

private fun maximumSaleItems(items: Array<IntArray>, budget: Int): Int {
    val n = items.size
    var min = Int.MAX_VALUE
    val dp = IntArray(budget + 1)
    for (i in 0 until n) {
        min = minOf(min, items[i][1])
        val cnt = items.count { (factor) -> factor % items[i][0] == 0 }
        for (j in budget downTo items[i][1])
            dp[j] = maxOf(dp[j], dp[j - items[i][1]] + cnt)
    }
    return (0..budget).maxOf { dp[it] + (budget - it) / min }
}
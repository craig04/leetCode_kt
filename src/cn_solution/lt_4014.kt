package cn_solution

fun minPrice(prices: IntArray, discounts: IntArray): Double {
    prices.sortDescending()
    discounts.sortDescending()
    return prices.indices.sumOf { i ->
        prices[i] * (100L - discounts.getOrElse(i) { 0 })
    } / 100.0
}
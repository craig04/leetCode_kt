package cn_solution

private fun maxCoins(piles: IntArray): Int {
    piles.sort()
    val n = piles.size
    return (n / 3 until n step 2).sumOf { piles[it] }
}
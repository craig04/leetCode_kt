package cn_solution

fun maxWeight(pizzas: IntArray): Long {
    pizzas.sortDescending()
    val n = pizzas.size
    val day = n / 4
    val odd = (day + 1) / 2
    return (0 until day).sumOf { pizzas[it + maxOf(it - odd, -1) + 1] + 0L }
}
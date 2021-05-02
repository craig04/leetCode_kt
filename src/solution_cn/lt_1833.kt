package solution_cn

fun maxIceCream(costs: IntArray, coins: Int): Int {
    costs.sort()
    var price = 0
    for (i in costs.indices) {
        price += costs[i]
        if (price > coins)
            return i
    }
    return costs.size
}
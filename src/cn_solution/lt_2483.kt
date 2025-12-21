package cn_solution

fun bestClosingTime(customers: String): Int {
    var cost = 0
    var best = 0
    var time = -1
    customers.forEachIndexed { i, c ->
        cost += if (c == 'Y') -1 else 1
        if (cost < best) {
            best = cost
            time = i
        }
    }
    return time + 1
}
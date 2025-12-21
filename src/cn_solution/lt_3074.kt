package cn_solution

fun minimumBoxes(apple: IntArray, capacity: IntArray): Int {
    var total = apple.sum()
    capacity.sortDescending()
    for (i in capacity.indices) {
        total -= capacity[i]
        if (total <= 0)
            return i + 1
    }
    return -1
}
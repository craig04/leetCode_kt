package cn_solution

fun averageWaitingTime(customers: Array<IntArray>): Double {
    var cur = 0
    return customers.sumOf { (arr, time) ->
        cur = maxOf(cur, arr) + time
        cur - arr + 0.0
    } / customers.size
}
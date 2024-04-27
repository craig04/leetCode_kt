package cn_solution

fun minimumMoney(transactions: Array<IntArray>): Long {
    var lose = 0L
    return transactions.maxOf { (cost, back) ->
        lose += maxOf(0, cost - back)
        minOf(cost, back)
    } + lose
}
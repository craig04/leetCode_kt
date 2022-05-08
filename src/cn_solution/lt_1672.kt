package cn_solution

fun maximumWealth(accounts: Array<IntArray>): Int {
    return accounts.fold(0) { acc, i -> maxOf(acc, i.sum()) }
}
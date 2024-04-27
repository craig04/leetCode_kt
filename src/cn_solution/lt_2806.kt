package cn_solution

fun accountBalanceAfterPurchase(purchaseAmount: Int): Int {
    return 100 - (purchaseAmount + 5) / 10 * 10
}
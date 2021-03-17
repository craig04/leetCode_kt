package solution

fun change(amount: Int, coins: IntArray): Int {
    val dp = Array(amount + 1) { 0 }
    dp[0] = 1
    for (c in coins) {
        for (i in c..amount) {
            dp[i] += dp[i - c]
        }
    }
    return dp[amount]
}
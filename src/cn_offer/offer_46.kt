package cn_offer

fun translateNum(num: Int): Int {
    val ca = num.toString().toCharArray()
    val size = ca.size
    val dp = IntArray(size + 1) { 1 }
    for (i in size - 2 downTo 0) {
        dp[i] = dp[i + 1]
        if (ca[i] == '2' && ca[i + 1] <= '5' || ca[i] == '1') {
            dp[i] += dp[i + 2]
        }
    }
    return dp[0]
}
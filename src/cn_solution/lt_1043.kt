package cn_solution

fun maxSumAfterPartitioning(arr: IntArray, k: Int): Int {
    val n = arr.size
    val dp = IntArray(n + 1)
    for (i in arr.indices.reversed()) {
        var max = 0
        for (j in i until minOf(i + k, n)) {
            max = maxOf(max, arr[j])
            dp[i] = maxOf(dp[i], dp[j + 1] + (j + 1 - i) * max)
        }
    }
    return dp[0]
}
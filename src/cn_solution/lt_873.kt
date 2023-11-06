package cn_solution

fun lenLongestFibSubseq(arr: IntArray): Int {
    val n = arr.size
    val dp = Array(n) { IntArray(n) { 2 } }
    val idx = arr.indices.associateByTo(HashMap()) { arr[it] }
    var result = 2
    for (j in 1 until n) {
        for (i in j - 1 downTo 0) {
            val k = idx[arr[j] - arr[i]] ?: continue
            if (k >= i)
                break
            dp[i][j] = maxOf(dp[i][j], dp[k][i] + 1)
            result = maxOf(result, dp[i][j])
        }
    }
    return if (result == 2) 0 else result
}
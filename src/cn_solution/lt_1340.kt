package cn_solution

fun maxJumps(arr: IntArray, d: Int): Int {
    val idx = Array(arr.size) { it }
    idx.sortByDescending { arr[it] }
    val dp = IntArray(arr.size)
    for (i in idx) {
        for (j in i + 1..minOf(i + d, arr.lastIndex)) {
            if (arr[j] >= arr[i])
                break
            dp[j] = maxOf(dp[j], dp[i] + 1)
        }
        for (j in i - 1 downTo maxOf(i - d, 0)) {
            if (arr[j] >= arr[i])
                break
            dp[j] = maxOf(dp[j], dp[i] + 1)
        }
    }
    return dp.max() + 1
}
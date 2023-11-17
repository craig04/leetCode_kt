package cn_solution

fun sumSubarrayMins(arr: IntArray): Int {
    val pos = ArrayList<Int>()
    val dp = ArrayList<Int>()
    val mod = 1000000007
    return arr.indices.fold(0) { acc, i ->
        val n = arr[i]
        while (pos.isNotEmpty() && n <= arr[pos.last()])
            pos.removeAt(pos.lastIndex)
        val temp = if (pos.isEmpty()) {
            n * (i + 1)
        } else {
            n * (i - pos.last()) % mod + dp[pos.last()]
        } % mod
        pos.add(i)
        dp.add(temp)
        (acc + temp) % mod
    }
}
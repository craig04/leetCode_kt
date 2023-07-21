package cn_solution

private const val MOD = 1000000007

fun numFactoredBinaryTrees(arr: IntArray): Int {
    val a = LongArray(arr.size) { arr[it].toLong() }
    a.sort()
    val map = a.indices.associateBy { a[it] }
    val factor = Array(arr.size) { ArrayList<Pair<Int, Int>>() }
    for (i in a.indices)
        for (j in a.indices)
            map[a[i] * a[j]]?.let { factor[it].add(Pair(i, j)) }
    val dp = LongArray(arr.size)
    for (pos in dp.indices) {
        dp[pos] = factor[pos].fold(1L) { acc, (i, j) -> (acc + dp[i] * dp[j]) % MOD }
    }
    return (dp.sum() % MOD).toInt()
}
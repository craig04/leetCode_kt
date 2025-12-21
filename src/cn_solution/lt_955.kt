package cn_solution

private fun minDeletionSize(strs: Array<String>): Int {
    val n = strs.size
    val m = strs[0].length
    val a = BooleanArray(n - 1)
    var ans = 0
    loop@ for (j in 0 until m) {
        for (i in 0 until n - 1)
            if (!a[i] && strs[i][j] > strs[i + 1][j]) {
                ans++
                continue@loop
            }
        for (i in 0 until n - 1)
            a[i] = a[i] || strs[i][j] < strs[i + 1][j]
    }
    return ans
}
package cn_solution

import kotlin.math.sign

private const val MOD = 1000000007

fun ways(pizza: Array<String>, k: Int): Int {
    val n = pizza.size
    val m = pizza[0].length
    val p = Array(n) { pizza[it].toCharArray() }
    val a = Array(n + 1) { IntArray(m + 1) }
    var pre = Array(n) { IntArray(m) }
    var cur = Array(n) { IntArray(m) }
    for (i in n - 1 downTo 0)
        for (j in m - 1 downTo 0) {
            a[i][j] = a[i + 1][j] + a[i][j + 1] - a[i + 1][j + 1] + (p[i][j] - '.').sign
            pre[i][j] = a[i][j].sign
        }
    for (t in 1 until k) {
        for (i in 0 until n)
            for (j in 0 until m) {
                var count = 0
                for (x in i + 1 until n)
                    if (a[i][j] > a[x][j])
                        count = (count + pre[x][j]) % MOD
                for (y in j + 1 until m)
                    if (a[i][j] > a[i][y])
                        count = (count + pre[i][y]) % MOD
                cur[i][j] = count
            }
        val tmp = cur
        cur = pre
        pre = tmp
    }
    return pre[0][0]
}
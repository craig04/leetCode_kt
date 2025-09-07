package cn_solution

fun minDifference(n: Int, k: Int): IntArray {
    val factor = ArrayList<Int>()
    var i = 1
    while (i * i < n) {
        if (n % i == 0) {
            factor.add(i)
            factor.add(n / i)
        }
        i++
    }
    if (i * i == n)
        factor.add(i)
    factor.sort()
    val ans = IntArray(k)
    var diff = Int.MAX_VALUE
    val path = IntArray(k)
    fun dfs(i: Int, from: Int, m: Int) {
        if (i == k - 1) {
            if (m - path[0] < diff) {
                diff = m - path[0]
                path[i] = m
                path.copyInto(ans)
            }
            return
        }
        for (j in from until factor.size) {
            val f = factor[j]
            if (m / f < f)
                break
            if (m % f == 0) {
                path[i] = factor[j]
                dfs(i + 1, j, m / factor[j])
            }
        }
    }
    dfs(0, 0, n)
    return ans
}
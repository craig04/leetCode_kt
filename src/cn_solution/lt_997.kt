package cn_solution

fun findJudge(n: Int, trust: Array<IntArray>): Int {
    val tin = IntArray(n + 1)
    val tout = BooleanArray(n + 1)
    for ((u, v) in trust) {
        tin[v]++
        tout[u] = true
    }
    var ans = -1
    for (i in 1..n)
        if (tin[i] == n - 1 && !tout[i])
            if (ans == -1)
                ans = i
            else
                return -1
    return ans
}
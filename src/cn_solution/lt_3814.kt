package cn_solution

fun maxCapacity(costs: IntArray, capacity: IntArray, budget: Int): Int {
    val n = costs.size
    val a = Array(n + 1) { IntArray(3) }
    for (i in 0 until n) {
        a[i + 1][0] = costs[i]
        a[i + 1][1] = capacity[i]
    }
    a.sortBy { it[0] }
    for (i in 0 until n)
        a[i + 1][2] = maxOf(a[i + 1][1], a[i][2])
    var ans = 0
    var i = 1
    for (j in n downTo 1) {
        if (a[j][0] >= budget)
            continue
        while (i < j && a[i][0] + a[j][0] < budget)
            i++
        ans = maxOf(ans, a[minOf(i, j) - 1][2] + a[j][1])
    }
    return ans
}
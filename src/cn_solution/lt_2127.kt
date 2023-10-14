package cn_solution

fun maximumInvitations(favorite: IntArray): Int {
    val n = favorite.size
    val degree = IntArray(n)
    favorite.forEach { degree[it]++ }
    val f = IntArray(n)
    val q = degree.indices.filterTo(ArrayDeque()) { degree[it] == 0 }
    while (q.isNotEmpty()) {
        val u = q.removeFirst()
        val v = favorite[u]
        f[v] = maxOf(f[v], f[u] + 1)
        if (--degree[v] == 0)
            q.add(v)
    }
    var double = 0
    var longest = 2
    for (i in 0 until n) {
        if (degree[i] == 0)
            continue
        var size = 0
        var j = i
        do {
            degree[j] = 0
            j = favorite[j]
            size++
        } while (j != i)
        if (size == 2)
            double += 2 + f[i] + f[favorite[i]]
        longest = maxOf(longest, size)
    }
    return maxOf(double, longest)
}
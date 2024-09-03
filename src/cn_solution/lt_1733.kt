package cn_solution

fun minimumTeachings(n: Int, languages: Array<IntArray>, friendships: Array<IntArray>): Int {
    val m = languages.size
    val f = Array(m + 1) { BooleanArray(n + 1) }
    for (i in 1..m)
        for (lan in languages[i - 1])
            f[i][lan] = true
    val barrier = BooleanArray(m + 1)
    loop@ for ((u, v) in friendships) {
        for (lan in 1..n)
            if (f[u][lan] && f[v][lan])
                continue@loop
        barrier[u] = true
        barrier[v] = true
    }
    return (1..n).minOf { lan -> (1..m).count { barrier[it] && !f[it][lan] } }
}
package cn_solution

fun isPossible(n: Int, edges: List<List<Int>>): Boolean {
    val d = IntArray(n + 1)
    edges.forEach {
        d[it[0]]++
        d[it[1]]++
    }
    val odd = d.indices.filter { d[it] and 1 == 1 }
    return when {
        odd.isEmpty() -> true
        odd.size == 2 -> {
            val (u, v) = odd
            val a = BooleanArray(n + 1) { true }
            val b = BooleanArray(n + 1) { true }
            for ((p, q) in edges) {
                fun add(x: Int, y: Int) {
                    if (x == u) a[y] = false
                    if (x == v) b[y] = false
                }
                add(p, q)
                add(q, p)
            }
            (a[v] && b[u]) || (1..n).any { a[it] && b[it] }
        }

        odd.size == 4 -> {
            val b = BooleanArray(16) { true }
            for (e in edges) {
                val u = odd.indexOf(e[0])
                if (u == -1)
                    continue
                val v = odd.indexOf(e[1])
                if (v == -1)
                    continue
                b[u * 4 + v] = false
                b[v * 4 + u] = false
            }
            (b[1] && b[11]) || (b[2] && b[7]) || (b[3] && b[6])
        }

        else -> false
    }
}
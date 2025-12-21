package cn_solution

fun findAllPeople_unionFind(n: Int, meetings: Array<IntArray>, firstPerson: Int): List<Int> {
    val p = IntArray(n) { it }
    p[firstPerson] = 0
    fun find(x: Int): Int {
        if (p[x] != x)
            p[x] = find(p[x])
        return p[x]
    }
    meetings.sortBy { it[2] }
    var i = 0
    val m = meetings.size
    while (i != m) {
        var j = i
        while (j != m && meetings[j][2] == meetings[i][2]) {
            val (x, y) = meetings[j++]
            val u = find(x)
            val v = find(y)
            when {
                u == 0 -> p[v] = 0
                v == 0 -> p[u] = 0
                u != v -> p[u] = v
            }
        }
        for (k in i until j) {
            val (x, y) = meetings[k]
            if (find(x) != 0)
                p[x] = x
            if (find(y) != 0)
                p[y] = y
        }
        i = j
    }
    return p.indices.filter { find(it) == 0 }
}

fun findAllPeople_bfs(n: Int, meetings: Array<IntArray>, firstPerson: Int): List<Int> {
    val s = BooleanArray(n)
    s[0] = true
    s[firstPerson] = true
    val g = HashMap<Int, ArrayList<Int>>()
    val v = HashSet<Int>()
    val q = ArrayDeque<Int>()
    meetings.sortBy { it[2] }
    var i = 0
    while (i < meetings.size) {
        g.clear()
        v.clear()
        q.clear()
        var j = i
        while (j != meetings.size && meetings[j][2] == meetings[i][2]) {
            val (a, b) = meetings[j++]
            if (s[a] && s[b])
                continue
            g.computeIfAbsent(a) { ArrayList() }.add(b)
            g.computeIfAbsent(b) { ArrayList() }.add(a)
            v.add(a)
            v.add(b)
        }
        for (t in v)
            if (s[t])
                q.addLast(t)
        while (q.isNotEmpty()) {
            for (b in g[q.removeFirst()] ?: emptyList()) {
                if (!s[b]) {
                    s[b] = true
                    q.addLast(b)
                }
            }
        }
        i = j
    }
    return s.indices.filter { s[it] }
}
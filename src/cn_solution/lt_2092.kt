package cn_solution

fun findAllPeople(n: Int, meetings: Array<IntArray>, firstPerson: Int): List<Int> {
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
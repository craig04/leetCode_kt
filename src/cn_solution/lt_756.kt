package cn_solution

fun pyramidTransition(bottom: String, allowed: List<String>): Boolean {
    val map = Array(6) { Array(6) { ArrayList<Char>() } }
    for (s in allowed)
        map[s[0] - 'A'][s[1] - 'A'].add(s[2])
    var curr = hashSetOf(bottom)
    repeat(bottom.lastIndex) {
        val next = HashSet<String>()
        val sb = StringBuilder()
        for (s in curr) {
            fun dfs(i: Int) {
                if (i == s.lastIndex) {
                    next.add(sb.toString())
                    return
                }
                val top = map[s[i] - 'A'][s[i + 1] - 'A']
                if (top.isEmpty())
                    return
                for (c in top) {
                    sb.append(c)
                    dfs(i + 1)
                    sb.deleteAt(sb.lastIndex)
                }
            }
            dfs(0)
        }
        if (next.isEmpty())
            return false
        curr = next
    }
    return true
}
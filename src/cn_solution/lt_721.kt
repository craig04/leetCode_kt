package cn_solution

fun accountsMerge(accounts: List<List<String>>): List<List<String>> {
    val p = IntArray(10000) { it }
    fun find(x: Int): Int {
        if (p[x] != x)
            p[x] = find(p[x])
        return p[x]
    }

    fun union(x: Int, y: Int) {
        val u = find(x)
        val v = find(y)
        p[maxOf(u, v)] = minOf(u, v)
    }

    var idx = accounts.size
    val emails = HashMap<String, Int>()
    for (i in accounts.indices) {
        for (j in 1 until accounts[i].size) {
            val t = emails.computeIfAbsent(accounts[i][j]) { idx++ }
            union(i, t)
        }
    }
    val ans = HashMap<Int, ArrayList<String>>()
    for ((email, index) in emails)
        ans.computeIfAbsent(find(index)) { ArrayList() }.add(email)
    return ans.map { (index, emails) ->
        emails.sortDescending()
        emails.add(accounts[index][0])
        emails.asReversed()
    }
}
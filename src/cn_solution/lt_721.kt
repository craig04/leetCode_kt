package cn_solution

fun accountsMerge(accounts: List<List<String>>): List<List<String>> {
    val mails = ArrayList<String>()
    val mailToId = HashMap<String, Int>()
    val idToName = HashMap<Int, String>()
    accounts.forEach {
        val name = it[0]
        for (i in 1 until it.size) {
            val mail = it[i]
            if (mail !in mailToId) {
                val id = mails.size
                mails.add(mail)
                mailToId[mail] = id
                idToName[id] = name
            }
        }
    }
    val uf = UnionFind(mails.size)
    accounts.forEach {
        val first = mailToId[it[1]]!!
        for (i in 2 until it.size) {
            uf.union(first, mailToId[it[i]]!!)
        }
    }
    val map = HashMap<Int, ArrayList<String>>()
    for (i in 0 until mails.size) {
        map.computeIfAbsent(uf.find(i)) { ArrayList() }.add(mails[i])
    }
    return map.map {
        ArrayList<String>().apply {
            add(idToName[it.key]!!)
            it.value.sort()
            addAll(it.value)
        }
    }
}

private class UnionFind(n: Int) {

    val fa = IntArray(n) { it }

    fun union(p: Int, q: Int) {
        fa[find(p)] = find(q)
    }

    fun find(n: Int): Int {
        if (fa[n] != n) {
            fa[n] = find(fa[n])
        }
        return fa[n]
    }
}
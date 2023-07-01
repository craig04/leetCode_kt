package cn_interview

fun findLadders(beginWord: String, endWord: String, wordList: List<String>): List<String> {
    val target = wordList.indexOf(endWord)
    if (target == -1) {
        return emptyList()
    }
    val n = wordList.size
    val adj = Array(n + 1) { ArrayList<Int>() }
    fun test(a: String, b: String, i: Int, j: Int) {
        if (a.length == b.length && a.indices.count { a[it] != b[it] } == 1) {
            adj[i].add(j)
            adj[j].add(i)
        }
    }
    for (i in wordList.indices) {
        val a = wordList[i]
        for (j in i + 1 until n) {
            test(a, wordList[j], i, j)
        }
        test(a, beginWord, i, n)
    }
    val path = arrayListOf(beginWord)
    val used = BooleanArray(n + 1)
    fun dfs(cur: Int): Boolean {
        if (cur == target)
            return true
        used[cur] = true
        for (next in adj[cur]) {
            if (!used[next]) {
                path.add(wordList[next])
                if (dfs(next))
                    return true
                path.removeAt(path.lastIndex)
            }
        }
        return false
    }
    return if (dfs(n)) path else emptyList()
}
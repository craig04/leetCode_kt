package cn_solution

fun findLadders(beginWord: String, endWord: String, wordList: List<String>): List<List<String>> {
    if (endWord !in wordList)
        return emptyList()
    fun String.adjacent(other: String) = indices.count { this[it] != other[it] } == 1
    class Path(val step: Int, val prev: ArrayList<String> = ArrayList())

    val info = hashMapOf(beginWord to Path(0, arrayListOf("")))
    val q = ArrayDeque<String>()
    q.addLast(beginWord)
    while (q.isNotEmpty()) {
        val cur = q.removeFirst()
        if (cur == endWord)
            break
        val step = info[cur]?.step ?: break
        for (w in wordList) {
            if (step < (info[w]?.step ?: Int.MAX_VALUE) && cur.adjacent(w)) {
                info.computeIfAbsent(w) {
                    q.addLast(w)
                    Path(step + 1)
                }.prev.add(cur)
            }
        }
    }
    val result = ArrayList<List<String>>()
    val path = ArrayList<String>()
    fun dfs(cur: String) {
        if (cur.isEmpty()) {
            result.add(path.reversed())
            return
        }
        path.add(cur)
        info[cur]?.prev?.forEach { dfs(it) }
        path.removeLast()
    }
    dfs(endWord)
    return result
}
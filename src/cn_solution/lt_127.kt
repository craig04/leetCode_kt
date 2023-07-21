package cn_solution

fun ladderLength(beginWord: String, endWord: String, wordList: List<String>): Int {
    val n = wordList.size
    val indices = wordList.indices.associateBy { wordList[it] }
    val q = ArrayDeque<Int>()
    val dist = IntArray(n + 1) { -1 }
    dist[n] = 1
    fun search(str: String, step: Int) {
        val cs = str.toCharArray()
        cs.forEachIndexed { i, c ->
            for (s in 'a'..'z') {
                if (c == s)
                    continue
                cs[i] = s
                val idx = indices[String(cs)] ?: continue
                if (dist[idx] == -1) {
                    dist[idx] = step + 1
                    q.add(idx)
                }
            }
            cs[i] = c
        }
    }
    search(beginWord, 1)
    while (q.isNotEmpty()) {
        val t = q.removeFirst()
        if (wordList[t] == endWord)
            return dist[t]
        search(wordList[t], dist[t])
    }
    return 0
}
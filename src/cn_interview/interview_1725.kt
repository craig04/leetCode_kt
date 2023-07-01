package cn_interview

fun maxRectangle(words: Array<String>): Array<String> {
    class Node(val parent: Node? = null) {
        var end: Boolean = false
        val next = Array<Node?>(26) { null }
    }

    var result = ArrayList<String>()
    var area = 0
    val root = Node()
    val map = HashMap<Int, ArrayList<String>>()
    for (word in words) {
        map.computeIfAbsent(word.length) { ArrayList() }.add(word)
        var node = root
        for (c in word) {
            val next = node.next[c - 'a'] ?: Node(node)
            node.next[c - 'a'] = next
            node = next
        }
        node.end = true
    }
    for ((len, list) in map) {
        val col = Array(len) { root }
        val candidates = ArrayList<String>()
        fun dfs(n: Int) {
            for (word in list) {
                var i = 0
                while (i != len) {
                    val next = col[i].next[word[i] - 'a'] ?: break
                    col[i++] = next
                }
                if (i == len) {
                    candidates.add(word)
                    if (len * candidates.size > area) {
                        area = len * candidates.size
                        result = ArrayList(candidates)
                    }
                    dfs(n + 1)
                    candidates.removeAt(candidates.lastIndex)
                }
                while (--i >= 0)
                    col[i] = col[i].parent ?: break
            }
        }
        dfs(0)
    }
    return Array(result.size) { result[it] }
}
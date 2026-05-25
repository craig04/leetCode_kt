package cn_solution

fun stringIndices(wordsContainer: Array<String>, wordsQuery: Array<String>): IntArray {
    class Node(var best: Int = 0) {
        val next = Array<Node?>(26) { null }
        fun length() = wordsContainer[best].length
    }

    val root = Node()
    for (i in wordsContainer.indices) {
        val word = wordsContainer[i]
        var node = root
        if (word.length < node.length())
            node.best = i
        for (k in word.indices.reversed()) {
            val c = word[k] - 'a'
            val next = node.next[c] ?: Node(i)
            node.next[c] = next
            node = next
            if (word.length < node.length()) {
                node.best = i
            }
        }
    }
    return IntArray(wordsQuery.size) { i ->
        var node = root
        for (j in wordsQuery[i].indices.reversed())
            node = node.next[wordsQuery[i][j] - 'a'] ?: break
        node.best
    }
}
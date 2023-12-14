package cn_solution

fun sumPrefixScores(words: Array<String>): IntArray {
    class Node {
        var cnt = 0
        var word: String? = null
        val next = Array<Node?>(26) { null }
    }

    val root = Node()
    for (word in words) {
        var node = root
        for (c in word) {
            val idx = c - 'a'
            val next = node.next[idx] ?: Node()
            node.next[idx] = next
            next.cnt++
            node = next
        }
        node.word = word
    }
    val map = HashMap<String, Int>()
    fun dfs(node: Node?, prev: Int) {
        node ?: return
        val sum = prev + node.cnt
        node.word?.let { map[it] = sum }
        node.next.forEach { dfs(it, sum) }
    }
    dfs(root, 0)
    return IntArray(words.size) { map[words[it]] ?: 0 }
}
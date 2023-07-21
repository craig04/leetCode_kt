package cn_solution

class WordDictionary() {

    private class Node {
        var end = false
        val next = Array<Node?>(26) { null }
    }

    private val root = Node()

    fun addWord(word: String) {
        var node = root
        for (c in word) {
            val next = node.next[c - 'a'] ?: Node()
            node.next[c - 'a'] = next
            node = next
        }
        node.end = true
    }

    fun search(word: String): Boolean {
        fun search(node: Node, pos: Int): Boolean {
            if (pos == word.length)
                return node.end
            val c = word[pos]
            return if (c == '.') {
                node.next.any { it != null && search(it, pos + 1) }
            } else {
                node.next[c - 'a']?.let { search(it, pos + 1) } == true
            }
        }
        return search(root, 0)
    }
}

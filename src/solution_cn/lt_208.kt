package solution_cn

class Trie() {

    class Node(var end: Boolean = false) {
        val next = Array<Node?>(26) { null }
    }

    private val root = Node()

    fun insert(word: String) {
        var temp = root
        for (c in word) {
            val t = c - 'a'
            val child = temp.next[t] ?: Node()
            temp.next[t] = child
            temp = child
        }
        temp.end = true
    }

    /** Returns if the word is in the trie. */
    fun search(word: String): Boolean {
        return searchWord(word)?.end == true
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    fun startsWith(prefix: String): Boolean {
        return searchWord(prefix) != null
    }

    private fun searchWord(word: String): Node? {
        var temp = root
        word.forEach {
            temp = temp.next[it - 'a'] ?: return null
        }
        return temp
    }
}

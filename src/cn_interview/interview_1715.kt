package cn_interview

fun longestWord(words: Array<String>): String {
    class Node(var end: Boolean = false) {
        val next = Array<Node?>(26) { null }
    }

    words.sortBy { it.length }
    val root = Node(false)
    fun test(node: Node, word: String, i: Int): Boolean {
        if (i == word.length)
            return node.end
        val next = node.next[word[i] - 'a'] ?: return false
        return test(next, word, i + 1)
                || (next.end && test(root, word, i + 1))
    }

    var result = ""
    for (word in words) {
        if (test(root, word, 0)) {
            val diff = word.length - result.length
            if (diff > 0 || (diff == 0 && word < result))
                result = word
        }
        var node = root
        for (c in word) {
            val next = node.next[c - 'a'] ?: Node()
            node.next[c - 'a'] = next
            node = next
        }
        node.end = true
    }
    return result
}
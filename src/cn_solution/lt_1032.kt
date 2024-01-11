package cn_solution

class StreamChecker(words: Array<String>) {

    class Node {
        val next = Array<Node?>(26) { null }
        var word = false
    }

    val root = Node().apply {
        for (word in words) {
            var node = this
            for (i in word.indices.reversed()) {
                val idx = word[i] - 'a'
                val next = node.next[idx] ?: Node()
                node.next[idx] = next
                node = next
            }
            node.word = true
        }
    }
    val q = ArrayList<Char>()

    fun query(letter: Char): Boolean {
        q.add(letter)
        var node = root
        for (i in q.indices.reversed()) {
            node = node.next[q[i] - 'a'] ?: break
            if (node.word)
                return true
        }
        return false
    }
}
package solution_cn

class MapSum() {

    private class Node {
        var sum = 0
        var self = 0
        var next = Array<Node?>(26) { null }
    }

    private val root = Node()

    fun insert(key: String, `val`: Int) {
        var node = root
        val list = ArrayList<Node>()
        for (c in key.toCharArray()) {
            val i = c - 'a'
            val next = node.next[i] ?: Node()
            node.next[i] = next
            list.add(next)
            node = next
        }
        val diff = `val` - node.self
        node.self = `val`
        for (n in list) {
            n.sum += diff
        }
    }

    fun sum(prefix: String): Int {
        var node = root
        for (c in prefix.toCharArray()) {
            node = node.next[c - 'a'] ?: return 0
        }
        return node.sum
    }
}

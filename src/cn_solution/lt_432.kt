package cn_solution

class AllOne() {

    class Node(val count: Int) {
        var prev: Node = this
        var next: Node = this
        val keys = HashSet<String>()
    }

    private val head = Node(0)
    private val nodes = HashMap<String, Node>()

    fun inc(key: String) = update(key, 1)

    fun dec(key: String) = update(key, -1)

    private fun update(key: String, delta: Int) {
        val node = nodes[key] ?: head
        val count = node.count + delta
        var target = if (delta > 0) node.next else node.prev
        if (target.count != count) {
            target = Node(count)
            val pivot = if (delta > 0) node else node.prev
            target.next = pivot.next
            target.prev = pivot
            pivot.next.prev = target
            pivot.next = target
        }
        nodes[key] = target
        target.keys.add(key)
        node.keys.remove(key)
        if (node.count != 0 && node.keys.isEmpty()) {
            node.prev.next = node.next
            node.next.prev = node.prev
        }
    }

    fun getMaxKey(): String {
        return head.prev.keys.firstOrNull() ?: ""
    }

    fun getMinKey(): String {
        return head.next.keys.firstOrNull() ?: ""
    }
}
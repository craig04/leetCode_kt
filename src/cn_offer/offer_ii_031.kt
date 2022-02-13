package cn_offer

class LRUCache(private val capacity: Int) {

    private class Node(val key: Int, var value: Int) {

        var prev: Node? = null
        var next: Node? = null

        fun remove() {
            prev?.next = next
            next?.prev = prev
        }

        fun insertAfter(other: Node) {
            prev = other
            next = other.next
            next?.prev = this
            other.next = this
        }
    }

    private var map = HashMap<Int, Node>()
    private var head: Node = Node(0, 0).apply {
        prev = this
        next = this
    }

    fun get(key: Int): Int {
        val node = map[key] ?: return -1
        node.remove()
        node.insertAfter(head)
        return node.value
    }

    fun put(key: Int, value: Int) {
        val node = map.remove(key)?.also {
            it.remove()
            it.value = value
        } ?: Node(key, value)
        if (map.size == capacity) {
            head.prev?.also {
                it.remove()
                map.remove(it.key)
            }
        }
        map[key] = node
        node.insertAfter(head)
    }
}
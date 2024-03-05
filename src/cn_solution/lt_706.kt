package cn_solution

class MyHashMap() {

    private class Node(val key: Int) {
        var value = 0
        var next: Node? = null
    }

    private val n = 10013
    private val buckets = Array<Node?>(n) { null }

    fun put(key: Int, value: Int) {
        val hash = key % n
        var node = buckets[hash]
        while (node != null) {
            if (node.key == key)
                break
            node = node.next
        }
        if (node == null) {
            node = Node(key)
            node.value = value
            node.next = buckets[hash]
            buckets[hash] = node
        } else {
            node.value = value
        }
    }

    fun get(key: Int): Int {
        val hash = key % n
        var node = buckets[hash]
        while (node != null) {
            if (node.key == key)
                return node.value
            node = node.next
        }
        return -1
    }

    fun remove(key: Int) {
        val hash = key % n
        var node = buckets[hash] ?: return
        if (node.key == key) {
            buckets[hash] = node.next
            return
        }
        while (true) {
            val next = node.next ?: break
            if (next.key == key) {
                node.next = next.next
                break
            }
            node = next
        }
    }
}
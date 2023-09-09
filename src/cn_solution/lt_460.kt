package cn_solution

class LFUCache(private val capacity: Int) {

    private class Node(val key: Int) {
        var value: Int = 0
        var freq: Int = 0
        var prev: Node? = this
        var next: Node? = this

        fun remove() {
            prev?.next = next
            next?.prev = prev
        }

        fun insert(other: Node) {
            prev = other
            next = other.next
            next?.prev = this
            other.next = this
        }
    }

    private val data = HashMap<Int, Node>()
    private val freq = HashMap<Int, Node>()
    private var least = 0

    fun get(key: Int): Int {
        val node = data[key] ?: return -1
        increaseFreq(node)
        return node.value
    }

    fun put(key: Int, value: Int) {
        val old = data[key]
        if (old != null) {
            old.value = value
            increaseFreq(old)
        } else {
            if (data.size == capacity) {
                freq[least]?.prev?.also {
                    it.remove()
                    data.remove(it.key)
                }
            }
            val new = Node(key)
            new.value = value
            new.freq = 1
            insertFreq(new)
            data[key] = new
            least = 1
        }
    }

    private fun increaseFreq(node: Node) {
        node.remove()
        if (node.freq == least && freq[least]?.let { it == it.next } == true)
            least++
        node.freq++
        insertFreq(node)
    }

    private fun insertFreq(node: Node) {
        node.insert(freq.computeIfAbsent(node.freq) { Node(0) })
    }
}
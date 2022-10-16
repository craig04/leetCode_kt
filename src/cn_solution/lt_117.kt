package cn_solution

class Solution_117 {

    class Node(var `val`: Int) {
        var left: Node? = null
        var right: Node? = null
        var next: Node? = null
    }

    fun connect(root: Node?): Node? {
        root ?: return null
        val q = ArrayDeque<Node>()
        var layer = 1
        var new = false
        var last = Node(0)
        q.add(root)
        while (q.isNotEmpty()) {
            val node = q.removeFirst()
            if (!new) last.next = node
            node.left?.let { q.addLast(it) }
            node.right?.let { q.addLast(it) }
            new = --layer == 0
            if (new) layer = q.size
            last = node
        }
        return root
    }
}
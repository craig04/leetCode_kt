package cn_solution

class Solution_117 {

    class Node(var `val`: Int) {
        var left: Node? = null
        var right: Node? = null
        var next: Node? = null
    }

    fun connect(root: Node?): Node? {
        val q = ArrayDeque<Node>()
        val dummy = Node(0)
        fun Node?.enqueue() = this?.also { q.add(it) }
        root.enqueue()
        while (q.isNotEmpty()) {
            var last = dummy
            repeat(q.size) {
                val node = q.removeFirst()
                last.next = node
                last = node
                node.left.enqueue()
                node.right.enqueue()
            }
        }
        return root
    }
}
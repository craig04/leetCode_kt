package cn_lcr

class Solution_LCR_028 {

    class Node(var `val`: Int) {
        var prev: Node? = null
        var next: Node? = null
        var child: Node? = null
    }

    fun flatten(root: Node?): Node? {
        fun Node?.flatten(tail: Node?): Node? {
            var node = this
            while (node != null) {
                val next = node.next
                val temp = node.child?.flatten(next ?: tail)
                if (temp != null) {
                    node.child = null
                    node.next = temp
                    temp.prev = node
                }
                if (next == null && node.next == null) {
                    node.next = tail
                    tail?.prev = node
                }
                node = next
            }
            return this
        }
        return root.flatten(null)
    }
}
package cn_solution

class Node(var `val`: Int) {
    var prev: Node? = null
    var next: Node? = null
    var child: Node? = null
}

fun flatten(root: Node?): Node? {
    fun Node.flatten(): Pair<Node, Node> {
        var curr = this
        do {
            val next = curr.next
            curr.child?.flatten()?.let { (head, tail) ->
                curr.next = head
                head.prev = curr
                tail.next = next
                next?.prev = tail
                curr.child = null
                curr = tail
            }
            curr = next ?: break
        } while (true)
        return Pair(this, curr)
    }
    return root?.flatten()?.first
}
package cn_solution

class AuthenticationManager(private val timeToLive: Int) {

    class Node(
        val token: String,
        var expireTime: Int,
        var prev: Node? = null,
        var next: Node? = null
    ) {
        fun remove() {
            prev?.next = next
            next?.prev = prev
        }

        fun addBefore(other: Node) {
            prev = other.prev
            next = other
            other.prev?.next = this
            other.prev = this
        }
    }

    private val tokens = HashMap<String, Node>()
    private val head = Node("", 0).apply {
        prev = this
        next = this
    }

    fun generate(tokenId: String, currentTime: Int) {
        val node = Node(tokenId, currentTime + timeToLive)
        tokens[tokenId] = node
        node.addBefore(head)
    }

    fun renew(tokenId: String, currentTime: Int) {
        val node = tokens.remove(tokenId) ?: return
        node.remove()
        if (node.expireTime <= currentTime)
            return
        node.expireTime = currentTime + timeToLive
        tokens[tokenId] = node
        node.addBefore(head)
    }

    fun countUnexpiredTokens(currentTime: Int): Int {
        while (head.next != head) {
            val next = head.next ?: break
            if (next.expireTime > currentTime)
                break
            next.remove()
            tokens.remove(next.token)
        }
        return tokens.size
    }
}
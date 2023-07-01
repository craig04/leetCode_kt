package cn_solution

fun suggestedProducts(products: Array<String>, searchWord: String): List<List<String>> {
    class Node(var word: String? = null) {
        val next = Array<Node?>(26) { null }
    }

    val root = Node()
    for (p in products) {
        var node = root
        for (c in p) {
            val next = node.next[c - 'a'] ?: Node()
            node.next[c - 'a'] = next
            node = next
        }
        node.word = p
    }
    val list = ArrayList<String>()
    fun dfs(node: Node?) {
        if (node == null || list.size == 3) {
            return
        }
        node.word?.let { list.add(it) }
        node.next.forEach { dfs(it) }
    }

    var node: Node? = root
    val result = ArrayList<List<String>>()
    for (c in searchWord) {
        node = node?.next?.get(c - 'a')
        list.clear()
        dfs(node)
        result.add(list)
    }
    return result
}
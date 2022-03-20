package cn_solution

/**
 * Solution using sort
 */
fun longestWord(words: Array<String>): String {
    var result = ""
    val stack = arrayListOf("")
    words.sort()
    for (w in words) {
        while (stack.last().length >= w.length) {
            stack.removeAt(stack.lastIndex)
        }
        val last = stack.last()
        if (w.length == last.length + 1 && w.startsWith(last)) {
            if (w.length > result.length) result = w
            stack.add(w)
        }
    }
    return result
}


/**
 * Solution using trie
 */
fun longestWord_trie(words: Array<String>): String {
    class Node(var exist: Boolean) {
        val child = Array<Node?>(26) { null }
    }

    val root = Node(true)
    for (w in words) {
        var temp = root
        for (c in w) {
            val idx = 'a' - c + 25
            val next = temp.child[idx] ?: Node(false)
            temp.child[idx] = next
            temp = next
        }
        temp.exist = true
    }
    var result = ""
    val builder = StringBuilder()
    fun dfs(node: Node?) {
        if (node?.exist != true) {
            return
        }
        if (builder.length >= result.length) {
            result = builder.toString()
        }
        node.child.indices.forEach {
            val c = 'a' + 25 - it
            builder.append(c)
            dfs(node.child[it])
            builder.deleteCharAt(builder.lastIndex)
        }
    }
    dfs(root)
    return result
}
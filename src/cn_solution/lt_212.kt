package cn_solution

fun findWords(board: Array<CharArray>, words: Array<String>): List<String> {
    class Node {
        var idx = -1
        var next = Array<Node?>(26) { null }
    }

    val root = Node()
    words.forEachIndexed { i, word ->
        var node = root
        for (c in word) {
            val idx = c - 'a'
            val next = node.next[idx] ?: Node()
            node.next[idx] = next
            node = next
        }
        node.idx = i
    }
    val result = HashSet<String>()
    val n = board.lastIndex
    val m = board[0].lastIndex
    fun dfs(i: Int, j: Int, node: Node) {
        val c = board[i][j]
        if (c == ' ')
            return
        val next = node.next[c - 'a'] ?: return
        if (next.idx != -1)
            result.add(words[next.idx])
        board[i][j] = ' '
        if (i != 0) dfs(i - 1, j, next)
        if (i != n) dfs(i + 1, j, next)
        if (j != 0) dfs(i, j - 1, next)
        if (j != m) dfs(i, j + 1, next)
        board[i][j] = c
    }
    for (i in 0..n)
        for (j in 0..m)
            dfs(i, j, root)
    return result.toList()
}
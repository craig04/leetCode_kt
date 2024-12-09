package cn_solution

private fun minValidStrings(words: Array<String>, target: String): Int {
    class Node {
        val next = Array<Node?>(26) { null }
    }

    val root = Node()
    for (word in words) {
        var node = root
        for (c in word) {
            val next = node.next[c - 'a'] ?: Node()
            node.next[c - 'a'] = next
            node = next
        }
    }
    val dp = IntArray(target.length + 1) { Int.MAX_VALUE / 2 }
    dp[target.length] = 0
    for (i in target.indices.reversed()) {
        var node = root
        for (j in i until target.length) {
            node = node.next[target[j] - 'a'] ?: break
            dp[i] = minOf(dp[i], dp[j + 1] + 1)
        }
    }
    return if (dp[0] >= Int.MAX_VALUE / 2) -1 else dp[0]
}
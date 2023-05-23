package cn_interview

fun respace(dictionary: Array<String>, sentence: String): Int {
    class Node(var end: Boolean = false) {
        val next = Array<Node?>(26) { null }
    }

    val root = Node(false)
    for (word in dictionary) {
        var node = root
        for (c in word) {
            val next = node.next[c - 'a'] ?: Node(false)
            node.next[c - 'a'] = next
            node = next
        }
        node.end = true
    }
    val len = sentence.length
    val dp = IntArray(len + 1)
    for (i in 0 until len) {
        dp[i + 1] = maxOf(dp[i + 1], dp[i])
        var node = root
        for (j in i until len) {
            node = node.next[sentence[j] - 'a'] ?: break
            if (node.end) {
                dp[j + 1] = maxOf(dp[j + 1], dp[i] + j - i + 1)
            }
        }
    }
    return len - dp[len]
}
package cn_solution

fun findAllConcatenatedWordsInADict(words: Array<String>): List<String> {
    class Node {
        var end = false
        var next = Array<Node?>(26) { null }
    }

    val root = Node()
    val dp = BooleanArray(31)
    val ans = ArrayList<String>()
    words.sortBy { it.length }
    for (word in words) {
        dp.fill(false, 0, word.length)
        dp[word.length] = true
        loop@ for (i in word.indices.reversed()) {
            var node = root
            for (j in i until word.length) {
                node = node.next[word[j] - 'a'] ?: break
                if (node.end && dp[j + 1]) {
                    dp[i] = true
                    continue@loop
                }
            }
        }
        if (dp[0]) {
            ans.add(word)
            continue
        }
        var node = root
        for (c in word) {
            val idx = c - 'a'
            val next = node.next[idx] ?: Node()
            node.next[idx] = next
            node = next
        }
        node.end = true
    }
    return ans
}
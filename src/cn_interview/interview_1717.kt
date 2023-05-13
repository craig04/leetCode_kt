package cn_interview

/**
 * Brute force solution
 */
fun multiSearch(big: String, smalls: Array<String>): Array<IntArray> {
    return Array(smalls.size) {
        val pattern = smalls[it]
        if (pattern.isEmpty()) {
            return@Array intArrayOf()
        }
        var pos = 0
        val result = ArrayList<Int>()
        while (true) {
            pos = big.indexOf(pattern, pos)
            if (pos == -1)
                break
            result.add(pos++)
        }
        result.toIntArray()
    }
}

/**
 * Trie solution
 */
fun multiSearch_trie(big: String, smalls: Array<String>): Array<IntArray> {

    class Node(var index: Int = -1) {
        val next = Array<Node?>(26) { null }
    }

    val root = Node(-1)
    smalls.forEachIndexed { i, small ->
        var node = root
        for (c in small) {
            var next = node.next[c - 'a']
            if (next == null) {
                next = Node(-1)
                node.next[c - 'a'] = next
            }
            node = next
        }
        node.index = i
    }
    val result = Array(smalls.size) { ArrayList<Int>() }
    for (i in big.indices) {
        var node = root
        for (j in i until big.length) {
            node = node.next[big[j] - 'a'] ?: break
            if (node.index != -1) {
                result[node.index].add(i)
            }
        }
    }
    return Array(smalls.size) { result[it].toIntArray() }
}
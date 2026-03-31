package cn_solution

private fun partitionString(s: String): List<String> {
    class Node {
        var next = Array(26) { null as Node? }
    }

    val root = Node()
    var node = root
    var i = 0
    val ans = arrayListOf<String>()
    for (j in s.indices) {
        val t = s[j] - 'a'
        var next = node.next[t]
        if (next != null) {
            node = next
        } else {
            next = Node()
            node.next[t] = next
            node = root
            ans.add(s.substring(i, j + 1))
            i = j + 1
        }
    }
    return ans
}
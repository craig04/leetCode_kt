package cn_solution

fun palindromePairs(words: Array<String>): List<List<Int>> {
    class Node {
        val next = Array<Node?>(26) { null }
        var pos = -1
    }

    val size = words.size
    val forward = Node()
    val reverse = Node()
    fun Node.add(s: String, pos: Int) {
        var node = this
        for (i in s.indices) {
            val c = s[i] - 'a'
            val next = node.next[c] ?: Node()
            node.next[c] = next
            node = next
        }
        node.pos = pos
    }
    words.forEachIndexed { i, word ->
        forward.add(word, i)
        reverse.add(word.reversed(), i)
    }
    val ans = HashSet<Int>()
    words.forEachIndexed { i, word ->
        val n = word.length
        val c = CharArray(2 * n + 1) { '#' }
        for (i in 0 until n)
            c[i * 2 + 1] = word[i]
        var l = 0
        var r = 0
        val len = IntArray(c.size)
        for (j in 1 until c.lastIndex) {
            var h = 0
            if (j <= r)
                h = minOf(len[r - j + l], r - j)
            while (h < minOf(j, 2 * n - j) && c[j - h - 1] == c[j + h + 1])
                h++
            if (j + h > r) {
                l = j - h
                r = j + h
            }
            len[j] = h
        }
        fun Node.valid() = pos != -1 && pos != i
        var node = reverse
        if (len[n] == n && node.valid())
            ans += i * size + node.pos
        for (j in word.indices) {
            node = node.next[word[j] - 'a'] ?: break
            if (len[n + j + 1] == n - j - 1 && node.valid())
                ans += i * size + node.pos
        }
        node = forward
        if (len[n] == n && node.valid())
            ans += node.pos * size + i
        for (j in word.indices.reversed()) {
            node = node.next[word[j] - 'a'] ?: break
            if (len[j] == j && node.valid())
                ans += node.pos * size + i
        }
    }
    return ans.map { listOf(it / size, it % size) }
}
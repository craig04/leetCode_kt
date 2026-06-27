package cn_solution

fun longestRepeating(s: String, queryCharacters: String, queryIndices: IntArray): IntArray {
    class Node(
        var len: Int = 1,
        var pre: Int = 1,
        var suf: Int = 1
    )

    val a = s.toCharArray()
    val n = a.size
    val tree = Array(n * 4) { Node() }

    fun merge(i: Int, l: Int, r: Int) {
        tree[i].apply {
            val x = tree[i * 2 + 1]
            val y = tree[i * 2 + 2]
            len = maxOf(x.len, y.len)
            pre = x.pre
            suf = y.suf
            val m = (l + r) / 2
            if (a[m] == a[m + 1]) {
                len = maxOf(len, x.suf + y.pre)
                if (x.pre == m - l + 1)
                    pre += y.pre
                if (y.pre == r - m)
                    suf += x.suf
            }
        }
    }

    fun init(i: Int, l: Int, r: Int) {
        if (l != r) {
            val m = (l + r) / 2
            init(i * 2 + 1, l, m)
            init(i * 2 + 2, m + 1, r)
            merge(i, l, r)
        }
    }

    fun update(i: Int, l: Int, r: Int, pos: Int) {
        if (l != r) {
            val m = (l + r) / 2
            if (pos <= m)
                update(i * 2 + 1, l, m, pos)
            if (pos > m)
                update(i * 2 + 2, m + 1, r, pos)
            merge(i, l, r)
        }
    }

    init(0, 0, n - 1)
    return IntArray(queryCharacters.length) {
        val t = queryIndices[it]
        val c = queryCharacters[it]
        a[t] = c
        update(0, 0, n - 1, t)
        tree.first().len
    }
}
package cn_solution

fun minDeletions(s: String, queries: Array<IntArray>): IntArray {
    val n = s.length
    val a = IntArray(n)
    fun update(i: Int, x: Int) {
        var j = i
        while (j < n) {
            a[j] += x
            j += j and -j
        }
    }

    fun query(i: Int): Int {
        var ans = 0
        var j = i
        while (j > 0) {
            ans += a[j]
            j = j and (j - 1)
        }
        return ans
    }

    val c = s.toCharArray()
    for (i in 1 until n)
        if (c[i - 1] == c[i])
            update(i, 1)
    val ans = ArrayList<Int>()
    for (q in queries) {
        if (q[0] == 1) {
            val j = q[1]
            if (j != 0)
                update(j, if (c[j - 1] == c[j]) -1 else 1)
            if (j != n - 1)
                update(j + 1, if (c[j] == c[j + 1]) -1 else 1)
            c[j] = 'A' + (c[j] - 'A').xor(1)
        } else {
            ans.add(query(q[2]) - query(q[1]))
        }
    }
    return ans.toIntArray()
}
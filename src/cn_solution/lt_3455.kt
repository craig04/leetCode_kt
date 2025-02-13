package cn_solution

fun shortestMatchingSubstring(s: String, p: String): Int {
    fun find(q: String): List<Int> {
        val res = mutableListOf<Int>()
        val c = "$q#$s".toCharArray()
        val z = IntArray(c.size)
        var l = 0
        var r = 0
        for (i in 1 until c.size) {
            if (i <= r)
                z[i] = minOf(r - i + 1, z[i - l])
            while (i + z[i] < c.size && c[i + z[i]] == c[z[i]])
                z[i]++
            if (i + z[i] - 1 > r) {
                l = i
                r = i + z[i] - 1
            }
            if (i > q.length && z[i] == q.length)
                res.add(i - q.length - 1)
        }
        if (q.isEmpty())
            res.add(s.length)
        return res
    }

    val (a, b, c) = p.split('*')
    val (x, y, z) = arrayOf(find(a), find(b), find(c))
    var (j, k) = intArrayOf(0, 0)
    var ans = Int.MAX_VALUE
    for (i in x.indices) {
        while (j < y.size && y[j] < x[i] + a.length)
            j++
        if (j == y.size)
            break
        while (k < z.size && z[k] < y[j] + b.length)
            k++
        if (k == z.size)
            break
        ans = minOf(ans, z[k] + c.length - x[i])
    }
    return if (ans == Int.MAX_VALUE) -1 else ans
}
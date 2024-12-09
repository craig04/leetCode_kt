package cn_lcp

fun fieldOfGreatestBlessing(forceField: Array<IntArray>): Int {
    val h = HashSet<Long>()
    val v = HashSet<Long>()
    for ((x, y, side) in forceField) {
        h.add(x * 2L - side)
        h.add(x * 2L + side)
        v.add(y * 2L - side)
        v.add(y * 2L + side)
    }
    val p = h.toLongArray().apply { sort() }
    val q = v.toLongArray().apply { sort() }
    val hor = p.indices.associateBy { p[it] }
    val ver = q.indices.associateBy { q[it] }
    val a = Array(hor.size + 2) { IntArray(ver.size + 2) { 0 } }
    for ((x, y, side) in forceField) {
        val l = hor[x * 2L - side] ?: 0
        val r = hor[x * 2L + side] ?: 0
        val b = ver[y * 2L - side] ?: 0
        val t = ver[y * 2L + side] ?: 0
        a[l + 1][b + 1]++
        a[l + 1][t + 2]--
        a[r + 2][b + 1]--
        a[r + 2][t + 2]++
    }
    var ans = 0
    for (i in 1 until hor.size)
        for (j in 1 until ver.size) {
            a[i][j] += a[i - 1][j] + a[i][j - 1] - a[i - 1][j - 1]
            ans = maxOf(ans, a[i][j])
        }
    return ans
}
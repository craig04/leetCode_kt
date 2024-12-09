package cn_solution

private fun minLength(s: String, numOps: Int): Int {
    var ops = 0
    val len = ArrayList<Int>()
    var pre = 0
    s.forEachIndexed { i, cur ->
        if (i and 1 != s[i] - '0')
            ops++
        if (cur != s[pre]) {
            len.add(i - pre)
            pre = i
        }
    }
    len.add(s.length - pre)
    if (minOf(ops, s.length - ops) <= numOps)
        return 1
    var l = 2
    var r = s.length
    while (l != r) {
        val m = (l + r) shr 1
        if (len.sumOf { it / (m + 1) } <= numOps)
            r = m
        else
            l = m + 1
    }
    return l
}
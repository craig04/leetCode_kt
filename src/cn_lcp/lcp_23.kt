package cn_lcp

fun isMagic(target: IntArray): Boolean {
    val n = target.size
    val m = n / 2
    val card = IntArray(n) { if (it < m) it * 2 + 2 else (it - m) * 2 + 1 }
    var len = 0
    while (len != n && target[len] == card[len])
        len++
    if (len == 0)
        return false
    var pos = len
    val buf = IntArray(n)
    while (pos < n) {
        var x = 0
        for (i in pos until n step 2)
            buf[x++] = card[i]
        var y = pos
        for (i in pos + 1 until n step 2)
            card[y++] = card[i]
        buf.copyInto(card, y, 0, x)
        for (i in pos until minOf(pos + len, n))
            if (target[i] != card[i])
                return false
        pos += len
    }
    return true
}
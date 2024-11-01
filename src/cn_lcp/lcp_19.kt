package cn_lcp

fun minimumOperations(leaves: String): Int {
    fun red(i: Int) = if (leaves[i] == 'r') 1 else 0
    var a = 1 - red(0)
    var b = 1 shl 30
    var c = 1 shl 30
    for (i in 1 until leaves.length) {
        val r = red(i)
        val x = a + 1 - r
        val y = minOf(a, b) + r
        val z = minOf(b, c) + 1 - r
        a = x
        b = y
        c = z
    }
    return c
}
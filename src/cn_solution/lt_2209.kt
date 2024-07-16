package cn_solution

fun minimumWhiteTiles(floor: String, numCarpets: Int, carpetLen: Int): Int {
    val n = floor.length
    val a = floor.toCharArray()
    var pre = IntArray(n + 1)
    var cur = IntArray(n + 1)
    a.forEachIndexed { i, c -> pre[i + 1] = c - '0' + pre[i] }
    for (t in 1..numCarpets) {
        for (i in a.indices)
            cur[i + 1] = minOf(a[i] - '0' + cur[i], pre[maxOf(i - carpetLen, -1) + 1])
        val tmp = pre
        pre = cur
        cur = tmp
    }
    return pre[n]
}
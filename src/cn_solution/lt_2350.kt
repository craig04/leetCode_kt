package cn_solution

fun shortestSequence(rolls: IntArray, k: Int): Int {
    var i = 0
    var len = 1
    var cnt = 0
    val idx = IntArray(k + 1)
    for (r in rolls) {
        if (idx[r] < len) {
            idx[r]++
            if (++cnt == k) {
                len++
                cnt = 0
            }
        }
    }
    return len
}
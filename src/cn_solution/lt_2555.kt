package cn_solution

fun maximizeWin(prizePositions: IntArray, k: Int): Int {
    val n = prizePositions.size
    var l = 0
    var r = 0
    var opt = 0
    var pre = 0
    var suf = 0
    var ans = 1
    for (m in prizePositions.indices) {
        while (r != n && prizePositions[r] - prizePositions[m] <= k) {
            suf++
            r++
        }
        ans = maxOf(ans, suf + opt)
        suf--
        pre++
        while (prizePositions[m] - prizePositions[l] > k) {
            pre--
            l++
        }
        opt = maxOf(opt, pre)
    }
    return ans
}
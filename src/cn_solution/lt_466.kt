package cn_solution

fun getMaxRepetitions(s1: String, n1: Int, s2: String, n2: Int): Int {
    val pos = HashMap<Int, Long>()
    var cnt1 = 0
    var cnt2 = 0
    var idx2 = 0
    while (true) {
        cnt1++
        for (c in s1)
            if (c == s2[idx2] && ++idx2 == s2.length) {
                cnt2++
                idx2 = 0
            }
        if (cnt1 == n1)
            return cnt2 / n2
        val old = pos.put(idx2, cnt1.toLong().shl(32) or cnt2.toLong())
        if (old != null) {
            val old1 = old.shr(32).toInt()
            val old2 = old.and(0xffffffff).toInt()
            val len1 = cnt1 - old1
            val round = (n1 - cnt1) / len1
            cnt1 += round * len1
            cnt2 += round * (cnt2 - old2)
            break
        }
    }
    while (cnt1++ != n1) {
        for (c in s1)
            if (c == s2[idx2] && ++idx2 == s2.length) {
                cnt2++
                idx2 = 0
            }
    }
    return cnt2 / n2
}
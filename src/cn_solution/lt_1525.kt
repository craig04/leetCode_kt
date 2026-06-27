package cn_solution

fun numSplits(s: String): Int {
    var occ = 0
    val pre = IntArray(s.length) {
        occ = 1 shl (s[it] - 'a') or occ
        occ.countOneBits()
    }
    occ = 0
    return (s.lastIndex downTo 1).count {
        occ = 1 shl (s[it] - 'a') or occ
        occ.countOneBits() == pre[it - 1]
    }
}
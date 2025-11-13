package cn_solution

fun countPalindromicSubsequence(s: String): Int {
    var suf = 0
    val cnt = IntArray(26)
    for (c in s) {
        val t = c - 'a'
        suf = 1 shl t or suf
        cnt[t]++
    }
    val res = IntArray(26)
    var pre = 0
    for (c in s) {
        val t = c - 'a'
        if (--cnt[t] == 0)
            suf = 1 shl t xor suf
        res[t] = pre and suf or res[t]
        pre = 1 shl t or pre
    }
    return res.sumOf { it.countOneBits() }
}
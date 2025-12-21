package cn_solution

fun residuePrefixes(s: String): Int {
    var set = 0
    var ans = 0
    for (i in s.indices) {
        set = 1.shl(s[i] - 'a').or(set)
        val cnt = set.countOneBits()
        when {
            cnt >= 3 -> break
            cnt == (i + 1) % 3 -> ans++
        }
    }
    return ans
}
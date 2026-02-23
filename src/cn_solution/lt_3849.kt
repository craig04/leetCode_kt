package cn_solution

fun maximumXor(s: String, t: String): String {
    val cnt = IntArray(2)
    for (c in t)
        cnt[c - '0']++
    return String(CharArray(s.length) { i ->
        val c = '1' - s[i]
        if (cnt[c] != 0) {
            cnt[c]--
            '1'
        } else {
            cnt[1 - c]--
            '0'
        }
    })
}
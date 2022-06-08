package cn_solution

fun findSubstringInWraproundString(p: String): Int {
    val len = IntArray(26)
    var temp = 1
    var last = p[0]
    for (c in p) {
        val idx = c - 'a'
        if ((c - last + 25) % 26 == 0) {
            temp++
        } else {
            temp = 1
        }
        last = c
        len[idx] = maxOf(len[idx], temp)
    }
    return len.sum()
}
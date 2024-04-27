package cn_solution

fun countAnagrams(s: String): Int {
    val modulo = 1000000007L
    var a = 1L
    var b = 1L
    var len = 0
    val cnt = IntArray(26)
    for (c in s) {
        if (c == ' ') {
            len = 0
            cnt.fill(0)
        } else {
            a = a * ++len % modulo
            b = b * ++cnt[c - 'a'] % modulo
        }
    }
    var pow = modulo - 2
    var c = 1L
    while (pow != 0L) {
        if (pow and 1 == 1L)
            c = c * b % modulo
        pow = pow shr 1
        b = b * b % modulo
    }
    return ((a * c) % modulo).toInt()
}
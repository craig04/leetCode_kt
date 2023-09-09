package cn_lcr

fun addBinary(a: String, b: String): String {
    val result = StringBuilder()
    var c = 0
    fun String.num(i: Int) = if (i < 0) 0 else this[i] - '0'
    for (i in 1..maxOf(a.length, b.length)) {
        val digit = a.num(a.length - i) + b.num(b.length - i) + c
        result.append('0' + digit.and(1))
        c = digit shr 1
    }
    if (c == 1)
        result.append('1')
    return result.reverse().toString()
}
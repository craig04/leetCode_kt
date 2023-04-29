package cn_solution

fun decodeString(s: String): String {
    var pos = 0
    val n = s.length
    fun decode(): String = buildString {
        val c = s[pos++]
        if (c.isDigit()) {
            var times = c - '0'
            while (s[pos].isDigit()) {
                times = s[pos++] - '0' + times * 10
            }
            val next = s[pos++]
            if (next == '[') {
                val segment = decode()
                repeat(times) { append(segment) }
                pos++
            } else {
                repeat(times) { append(next) }
            }
        } else {
            append(c)
        }
        if (pos != n && s[pos] != ']')
            append(decode())
    }
    return decode()
}
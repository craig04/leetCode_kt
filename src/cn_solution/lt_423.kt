package cn_solution

fun originalDigits(s: String): String {
    val digits = IntArray(26)
    s.forEach { digits[it - 'a']++ }
    val c = IntArray(10)
    fun Char.cnt() = digits[this - 'a']
    c[0] = 'z'.cnt()
    c[2] = 'w'.cnt()
    c[4] = 'u'.cnt()
    c[6] = 'x'.cnt()
    c[8] = 'g'.cnt()
    c[3] = 'h'.cnt() - c[8]
    c[5] = 'f'.cnt() - c[4]
    c[7] = 's'.cnt() - c[6]
    c[1] = 'o'.cnt() - c[0] - c[2] - c[4]
    c[9] = 'i'.cnt() - c[5] - c[6] - c[8]
    return buildString { c.forEachIndexed { i, n -> repeat(n) { append(i) } } }
}
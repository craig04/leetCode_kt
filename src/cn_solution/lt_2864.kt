package cn_solution

fun maximumOddBinaryNumber(s: String): String {
    val cnt = s.count { it == '1' }
    val odd = CharArray(s.length) { '0' }
    for (i in 0 until cnt - 1)
        odd[i] = '1'
    odd[s.lastIndex] = '1'
    return String(odd)
}
package cn_solution

fun countHomogenous(s: String): Int {
    var result = 0L
    var begin = 0
    val len = s.length
    while (begin != len) {
        val end = (begin + 1 until len).firstOrNull { s[it] != s[begin] } ?: len
        val step = (end - begin).toLong()
        result += step * (step + 1) / 2
        begin = end
    }
    return (result % 1000000007).toInt()
}

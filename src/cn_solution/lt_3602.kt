package cn_solution

fun concatHex36(n: Int): String {
    val sb = StringBuilder()
    fun convert(n: Int, radix: Int) {
        var m = n
        while (m != 0) {
            val t = m % radix
            m /= radix
            sb.append(if (t < 10) t else 'A' + t - 10)
        }
    }
    convert(n * n * n, 36)
    convert(n * n, 16)
    return sb.reverse().toString()
}
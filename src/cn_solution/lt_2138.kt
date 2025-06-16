package cn_solution

fun divideString(s: String, k: Int, fill: Char): Array<String> {
    val suf = fill.toString()
    return Array((s.length + k - 1) / k) {
        val l = it * k
        val r = minOf(l + k, s.length)
        s.substring(l, r) + suf.repeat(k - (r - l))
    }
}
package cn_offer

fun countDigitOne(n: Int): Int {
    var result = 0L
    var base = 1L
    while (n >= base) {
        val next = base * 10
        result += (n / next) * base
        result += minOf(base, maxOf(0, n % next - base + 1))
        base = next
    }
    return result.toInt()
}
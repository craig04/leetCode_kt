package cn_solution

fun divide(dividend: Int, divisor: Int): Int {
    if (dividend == 0)
        return 0
    if (divisor == Int.MIN_VALUE)
        return if (dividend == divisor) 1 else 0
    if (dividend == Int.MIN_VALUE) {
        if (divisor == 1)
            return Int.MIN_VALUE
        else if (divisor == -1)
            return Int.MAX_VALUE
    }

    fun calculate(a: Int, b: Int): Int {
        if (a > b)
            return 0
        var base = b
        var time = 1
        while (a - base <= base) {
            base = base shl 1
            time = time shl 1
        }
        return time + calculate(a - base, b)
    }

    val c = if (dividend < 0) dividend else -dividend
    val d = if (divisor < 0) divisor else -divisor
    val rev = (dividend < 0) xor (divisor < 0)
    val result = calculate(c, d)
    return if (rev) -result else result
}
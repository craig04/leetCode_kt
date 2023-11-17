package cn_solution

fun divide(a: Int, b: Int): Int {
    if (a == 0)
        return 0
    if (b == Int.MIN_VALUE)
        return if (a == b) 1 else 0
    if (a == Int.MIN_VALUE) {
        if (b == 1)
            return Int.MIN_VALUE
        else if (b == -1)
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

    val c = if (a < 0) a else -a
    val d = if (b < 0) b else -b
    val rev = (a < 0) xor (b < 0)
    val result = calculate(c, d)
    return if (rev) -result else result
}
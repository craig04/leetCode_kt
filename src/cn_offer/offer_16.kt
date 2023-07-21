package cn_offer

fun myPow(x: Double, n: Int): Double {
    fun calc(x: Double, n: Int): Double {
        var result = 1.0
        var base = x
        var temp = n
        while (temp != 0) {
            if (temp and 1 != 0)
                result *= base
            temp /= 2
            base *= base
        }
        return result
    }
    return when {
        n == 0 -> 1.0
        n == Int.MIN_VALUE -> 1 / x / myPow(x, Int.MAX_VALUE)
        n < 0 -> 1 / calc(x, -n)
        else -> calc(x, n)
    }
}
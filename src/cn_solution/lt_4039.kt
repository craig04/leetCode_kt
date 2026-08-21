package cn_solution

fun sumDecoded(nums: LongArray): Int {
    val modulo = 1000000007
    val pow = LongArray(15)
    pow[0] = 1
    for (i in 1 until pow.size)
        pow[i] = pow[i - 1] * 10
    return nums.fold(0L) { ans, num ->
        var len = 0
        var tmp = num
        while (tmp != 0L) {
            tmp /= 10
            len++
        }
        val w = num.mod(10)
        var x = num / pow[len - w]
        var y = num % pow[len - w] / 10
        var res = 1L
        while (y != 0L) {
            if (y and 1 == 1L)
                res = res * x % modulo
            x = x * x % modulo
            y = y shr 1
        }
        ans + res
    }.mod(modulo)
}
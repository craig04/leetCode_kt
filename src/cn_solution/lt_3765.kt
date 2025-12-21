package cn_solution

fun completePrime(num: Int): Boolean {
    fun test(n: Int): Boolean {
        if (n <= 1)
            return false
        var i = 2
        while (i * i <= n)
            if (n % i++ == 0)
                return false
        return true
    }
    if (!test(num))
        return false
    var pre = num / 10
    var suf = num % 10
    var pow = 10
    while (pre != 0) {
        if (!test(pre) || !test(suf))
            return false
        suf += pre % 10 * pow
        pow *= 10
        pre /= 10
    }
    return true
}
package cn_solution

fun largestPalindrome(n: Int): Int {
    if (n == 1)
        return 9
    var pow = 1L
    repeat(n) { pow *= 10 }
    for (left in pow - 1 downTo 0) {
        var x = left
        var t = left
        while (t != 0L) {
            x = x * 10 + t % 10
            t /= 10
        }
        var j = pow - 1
        while (j * j >= x) {
            if (x % j == 0L)
                return x.mod(1337)
            j--
        }
    }
    return -1
}
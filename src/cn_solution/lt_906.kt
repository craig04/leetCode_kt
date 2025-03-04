package cn_solution

fun superpalindromesInRange(left: String, right: String): Int {

    fun palindrome(x: Long): Boolean {
        var a = x
        var b = 0L
        while (a != 0L) {
            b = b * 10 + a % 10
            a /= 10
        }
        return b == x
    }

    var ans = 0
    var low = 1
    var high = 10
    val l = left.toLong()
    val r = right.toLong()
    loop@ while (true) {
        for (i in low until high) {
            var x = i / 10
            var y = 0L
            while (x != 0) {
                y = y * 10 + x % 10
                x /= 10
            }
            y += i * low
            y *= y
            when {
                y < l -> continue
                y > r -> break@loop
                palindrome(y) -> ans++
            }
        }
        for (i in low until high) {
            var x = i
            var y = 0L
            while (x != 0) {
                y = y * 10 + x % 10
                x /= 10
            }
            y += i * high
            y *= y
            when {
                y < l -> continue
                y > r -> break@loop
                palindrome(y) -> ans++
            }
        }
        low = high
        high *= 10
    }
    return ans
}
package cn_solution

fun minimumSum(num: Int): Int {
    var ans = 0
    var a = 9
    var b = 9
    var x = num
    while (x > 0) {
        val y = x % 10
        x /= 10
        if (y < a) {
            b = a
            a = y
        } else if (y < b) {
            b = y
        }
        ans += y
    }
    return ans + (a + b) * 9
}
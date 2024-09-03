package cn_solution

fun generateKey(num1: Int, num2: Int, num3: Int): Int {
    var ans = 0
    var pow = 1
    var t1 = num1
    var t2 = num2
    var t3 = num3
    while (t1 + t2 + t3 != 0) {
        ans += pow * minOf(t1 % 10, t2 % 10, t3 % 10)
        t1 /= 10
        t2 /= 10
        t3 /= 10
        pow *= 10
    }
    return ans
}
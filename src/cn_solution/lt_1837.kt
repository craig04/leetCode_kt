package cn_solution

fun sumBase(n: Int, k: Int): Int {
    var m = n
    var ans = 0
    while (m > 0) {
        ans += m % k
        m /= k
    }
    return ans
}
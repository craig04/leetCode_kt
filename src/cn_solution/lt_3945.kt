package cn_solution

fun digitFrequencyScore(n: Int): Int {
    var ans = 0
    var m = n
    while (m != 0) {
        ans += m % 10
        m /= 10
    }
    return ans
}
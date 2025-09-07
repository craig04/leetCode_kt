package cn_solution

fun getLeastFrequentDigit(n: Int): Int {
    val cnt = IntArray(10)
    var m = n
    while (m != 0) {
        cnt[m % 10]++
        m /= 10
    }
    return cnt.indices.minBy { if (cnt[it] == 0) Int.MAX_VALUE else cnt[it] }
}
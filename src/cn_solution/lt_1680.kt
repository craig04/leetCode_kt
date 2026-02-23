package cn_solution

fun concatenatedBinary(n: Int): Int {
    var ans = 0L
    for (i in 1..n) {
        val w = 32 - i.countLeadingZeroBits()
        ans = ans.shl(w).plus(i) % 1000000007
    }
    return ans.toInt()
}
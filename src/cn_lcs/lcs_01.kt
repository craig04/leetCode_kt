package cn_lcs

fun leastMinutes(n: Int): Int {
    return 33 - (n - 1).takeHighestOneBit().countLeadingZeroBits()
}
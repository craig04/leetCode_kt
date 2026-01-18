package cn_solution

fun countMonobit(n: Int): Int {
    return 31 - (n + 1).countLeadingZeroBits()
}
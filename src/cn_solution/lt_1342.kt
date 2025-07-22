package cn_solution

fun numberOfSteps(num: Int): Int {
    return maxOf(0, 31 - num.countLeadingZeroBits() + num.countOneBits())
}
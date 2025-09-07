package cn_solution

fun minBitFlips(start: Int, goal: Int): Int {
    return start.xor(goal).countOneBits()
}
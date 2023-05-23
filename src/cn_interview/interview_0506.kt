package cn_interview

fun convertInteger(A: Int, B: Int): Int {
    return Integer.bitCount(A xor B)
}
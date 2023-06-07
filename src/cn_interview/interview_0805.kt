package cn_interview

fun multiply(A: Int, B: Int): Int {
    if (B == 1) return A
    return multiply(A shl 1, B shr 1) + if (B and 1 == 1) A else 0
}
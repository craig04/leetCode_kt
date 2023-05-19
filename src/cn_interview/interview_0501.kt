package cn_interview

fun insertBits(N: Int, M: Int, i: Int, j: Int): Int {
    val left = N shr (j + 1) shl j shl 1
    val right = (1 shl i) - 1 and N
    return M shl i or left or right
}
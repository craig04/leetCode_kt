package cn_interview

fun exchangeBits(num: Int): Int {
    val mask = 0x55555555
    return (num and mask shl 1) or (num shr 1 and mask)
}
package cn_solution

private val B1 = 0x55555555
private val B2 = 0x33333333
private val B4 = 0x0f0f0f0f
private val B8 = 0x00ff00ff

// you need treat n as an unsigned value
fun reverseBits(n: Int): Int {
    var m = n
    m = (m ushr 1 and B1) or (m and B1 shl 1)
    m = (m ushr 2 and B2) or (m and B2 shl 2)
    m = (m ushr 4 and B4) or (m and B4 shl 4)
    m = (m ushr 8 and B8) or (m and B8 shl 8)
    return (m ushr 16) or (m shl 16)
}

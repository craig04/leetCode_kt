package cn_solution

fun hammingWeight(n: Int): Int {
    var m = n
    m = (m and 0x55555555) + (m ushr 1 and 0x55555555)
    m = (m and 0x33333333) + (m ushr 2 and 0x33333333)
    m = (m and 0x0f0f0f0f) + (m ushr 4 and 0x0f0f0f0f)
    m = (m and 0x00ff00ff) + (m ushr 8 and 0x00ff00ff)
    return (m and 0xffff) + (m ushr 16)
}
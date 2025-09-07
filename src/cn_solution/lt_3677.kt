package cn_solution

fun countBinaryPalindromes(n: Long): Int {
    val w = 64 - n.countLeadingZeroBits()
    var ans = (0 until w).sumOf {
        1.shl((it - 1) / 2)
    }
    for (i in w - 2 downTo w / 2) {
        if (1L.shl(i) and n != 0L)
            ans += 1.shl(i - w / 2)
    }
    var pal = n.shr(w / 2)
    var x = pal.shr(w % 2)
    while (x != 0L) {
        pal = pal * 2 + x % 2
        x /= 2
    }
    if (pal <= n)
        ans++
    return ans
}
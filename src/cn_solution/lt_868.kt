package cn_solution

fun binaryGap_method1(n: Int): Int {
    var ans = 0
    var low = n and -n
    var num = n and n - 1
    while (num != 0) {
        ans = maxOf(ans, num.countTrailingZeroBits() - low.countTrailingZeroBits())
        low = num and -num
        num = num and num - 1
    }
    return ans
}

fun binaryGap_method2(n: Int): Int {
    var ans = 0
    var m = n.shr(n.countTrailingZeroBits() + 1)
    while (m != 0) {
        val cnt = m.countTrailingZeroBits() + 1
        ans = maxOf(ans, cnt)
        m = m.shr(cnt)
    }
    return ans
}
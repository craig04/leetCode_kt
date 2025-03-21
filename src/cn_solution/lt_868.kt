package cn_solution

fun binaryGap(n: Int): Int {
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
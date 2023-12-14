package cn_solution

fun largestMultipleOfThree(digits: IntArray): String {
    var sum = 0
    val cnt = Array(3) { IntArray(4) }
    for (digit in digits) {
        sum += digit
        cnt[digit % 3][digit / 3]++
    }
    fun remove(a: IntArray, count: Int): Boolean {
        var remain = count
        for (i in a.indices) {
            val t = minOf(a[i], remain)
            a[i] -= t
            remain -= t
            if (remain == 0)
                return true
        }
        return false
    }

    val rem = sum % 3
    if (rem != 0)
        remove(cnt[rem], 1) || remove(cnt[3 - rem], 2)
    val sb = StringBuilder()
    for (i in 9 downTo 0)
        repeat(cnt[i % 3][i / 3]) { sb.append('0' + i) }
    return if (sb.getOrNull(0) == '0') "0" else sb.toString()
}
package cn_solution

fun findTheLongestBalancedSubstring(s: String): Int {
    var result = 0
    var zero = 0
    var one = 0
    var last = '0'
    for (c in s) {
        when {
            c == '1' -> one++
            last == '0' -> zero++
            else -> {
                result = maxOf(result, minOf(zero, one))
                zero = 1
                one = 0
            }
        }
        last = c
    }
    return maxOf(result, minOf(zero, one)) * 2
}
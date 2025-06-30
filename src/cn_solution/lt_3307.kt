package cn_solution

fun kthCharacter(k: Long, operations: IntArray): Char {
    var m = 0
    var t = k - 1
    while (t != 0L) {
        m += operations[t.countTrailingZeroBits()]
        t = t and t - 1
    }
    return 'a' + m % 26
}
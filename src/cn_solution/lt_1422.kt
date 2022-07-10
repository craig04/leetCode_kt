package cn_solution

fun maxScore(s: String): Int {
    var one = 0
    var temp = 0
    var delta = 0
    for (i in 1 until s.length - 1) {
        val num = s[i] - '0'
        one += num
        temp += 1 - num.shl(1)
        delta = maxOf(delta, temp)
    }
    return s.last() - s.first() + 1 + one + delta
}
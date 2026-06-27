package cn_solution

fun largestInteger(n: Int, s: Int): Int {
    var ans = 0
    var sum = s
    repeat(n) {
        val d = minOf(9, sum)
        ans = ans * 10 + d
        sum -= d
    }
    return if (sum > 0) -1 else sum
}
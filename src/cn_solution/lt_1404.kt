package cn_solution

fun numSteps(s: String): Int {
    var ans = s.length - 1
    val pos = s.lastIndexOf('0')
    if (pos != 0)
        ans += (0 until pos).sumOf { '1' - s[it] } + 2
    return ans
}
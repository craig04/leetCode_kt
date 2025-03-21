package cn_solution

fun minimumCost(s: String): Long {
    var ans = 0L
    for (i in 1 until s.length)
        if (s[i - 1] != s[i])
            ans += minOf(i, s.length - i)
    return ans
}
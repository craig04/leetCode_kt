package cn_solution

fun lexSmallest(s: String): String {
    val n = s.length
    var ans = s
    val c = s.toCharArray()
    for (len in 2..s.length) {
        c.reverse(0, len)
        ans = minOf(ans, String(c))
        c.reverse(0, len)
        c.reverse(n - len, n)
        ans = minOf(ans, String(c))
        c.reverse(n - len, n)
    }
    return ans
}
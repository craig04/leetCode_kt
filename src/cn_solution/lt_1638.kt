package cn_solution

fun countSubstrings(s: String, t: String): Int {
    var ans = 0
    val n = s.length
    val m = t.length
    for (d in 1 - m until n) {
        var i = maxOf(0, d)
        var j = i - d
        var x = i - 1
        var y = i - 1
        while (i != n && j != m) {
            if (s[i++] != t[j++]) {
                y = x
                x = i - 1
            }
            ans += x - y
        }
    }
    return ans
}
package cn_solution

fun maximumGain(s: String, x: Int, y: Int): Int {
    if (x < y) {
        val c = s.toCharArray()
        for (i in c.indices)
            when (c[i]) {
                'a' -> c[i]++
                'b' -> c[i]--
            }
        return maximumGain(String(c), y, x)
    }
    val n = s.length
    var i = 0
    var ans = 0
    while (i < n) {
        var a = 0
        var b = 0
        while (i != n && s[i] in 'a'..'b') {
            if (s[i++] == 'a')
                a++
            else if (a != 0) {
                a--
                ans += x
            } else
                b++
        }
        ans += minOf(a, b) * y
        i++
    }
    return ans
}
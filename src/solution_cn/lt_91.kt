package solution_cn

fun numDecodings(s: String): Int {
    var a = 1
    var b = if (s[0] == '0') 0 else 1
    for (i in 1 until s.length) {
        var c = 0
        if (s[i - 1] == '1' || (s[i - 1] == '2' && s[i] <= '6')) {
            c += a
        }
        if (s[i] != '0') {
            c += b
        }
        a = b
        b = c
    }
    return b
}
package cn_solution

fun backspaceCompare(s: String, t: String): Boolean {
    var i = s.length
    var j = t.length
    var x = 0
    var y = 0
    while (i != 0 || j != 0) {
        var a = 'A'
        var b = 'A'
        while (i != 0 && x >= 0) {
            if (s[--i] == '#') x++
            else if (x > 0) x--
            else {
                a = s[i]
                break
            }
        }
        while (j != 0 && y >= 0) {
            if (t[--j] == '#') y++
            else if (y > 0) y--
            else {
                b = t[j]
                break
            }
        }
        if (a != b) return false
    }
    return true
}
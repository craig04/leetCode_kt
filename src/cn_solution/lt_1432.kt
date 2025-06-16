package cn_solution

fun maxDiff(num: Int): Int {
    val s = num.toString()
    var pos = s.indexOfFirst { it != '9' }
    val max = if (pos == -1) s else s.replace(s[pos], '9')
    val min = if (s[0] != '1')
        s.replace(s[0], '1')
    else {
        pos = s.indexOfFirst { it > '1' }
        if (pos == -1) s else s.replace(s[pos], '0')
    }
    return max.toInt() - min.toInt()
}
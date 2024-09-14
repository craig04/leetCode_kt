package cn_solution

fun monotoneIncreasingDigits(n: Int): Int {
    val s = n.toString().toCharArray()
    val i = (1 until s.size).firstOrNull {
        s[it - 1] > s[it]
    } ?: return n
    var j = i - 1
    while (j != 0 && s[j - 1] == s[j])
        j--
    s[j]--
    s.fill('9', j + 1)
    return String(s).toInt()
}
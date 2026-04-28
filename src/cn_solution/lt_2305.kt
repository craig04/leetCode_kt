package cn_solution

fun checkZeroOnes(s: String): Boolean {
    val len = IntArray(2)
    val n = s.length
    var i = 0
    while (i != n) {
        var j = i + 1
        while (j != n && s[j] == s[i])
            j++
        val x = s[i] - '0'
        len[x] = maxOf(len[x], j - i)
        i = j
    }
    return len[0] > len[1]
}
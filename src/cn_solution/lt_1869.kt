package cn_solution

private fun checkZeroOnes(s: String): Boolean {
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
    return len[1] > len[0]
}
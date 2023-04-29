package cn_solution

private fun isValid(s: String): Boolean {
    if (s.length % 3 != 0)
        return false
    val stk = CharArray(s.length)
    var pos = 0
    for (c in s) {
        stk[pos++] = c
        if (pos >= 3 && stk[pos - 1] == 'c' && stk[pos - 2] == 'b' && stk[pos - 3] == 'a')
            pos -= 3
    }
    return pos == 0
}
package cn_solution

private fun isValid(s: String): Boolean {
    val map = hashMapOf(')' to '(', '}' to '{', ']' to '[')
    val buf = CharArray(s.length + 1)
    var pos = 1
    for (c in s) {
        val x = map[c]
        if (x == null)
            buf[pos++] = c
        else if (buf[--pos] != x)
            return false
    }
    return pos == 1
}
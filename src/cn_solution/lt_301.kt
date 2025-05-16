package cn_solution

fun removeInvalidParentheses(s: String): List<String> {
    var left = 0
    var right = 0
    for (c in s) {
        when {
            c == '(' -> left++
            c != ')' -> continue
            left > 0 -> left--
            else -> right++
        }
    }
    var m = 0
    var n = 0
    for (i in s.indices) {
        when (s[i]) {
            '(' -> m = m or (1 shl i)
            ')' -> n = n or (1 shl i)
        }
    }
    fun init(bit: Int, del: Int): List<Int> {
        val cnt = bit.countOneBits() - del
        var cur = bit
        val ans = ArrayList<Int>()
        do {
            if (cur.countOneBits() == cnt)
                ans.add(cur)
            cur = (cur - 1) and bit
        } while (cur != bit)
        return ans
    }

    val x = init(m, left)
    val y = init(n, right)

    val ans = HashSet<String>()
    val buf = CharArray(s.length - left - right)
    for (i in x)
        loop@ for (j in y) {
            var t = 0
            var cnt = 0
            for (k in s.indices) {
                if (s[k] == '(') {
                    if (1.shl(k).and(i) == 0)
                        continue
                    cnt++
                } else if (s[k] == ')') {
                    if (1.shl(k).and(j) == 0)
                        continue
                    if (cnt-- == 0)
                        continue@loop
                }
                buf[t++] = s[k]
            }
            ans.add(String(buf))
        }
    return ans.toList()
}
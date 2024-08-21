package cn_solution

fun robotWithString(s: String): String {
    val cnt = IntArray(26)
    for (c in s)
        cnt[c - 'a']++
    val ans = StringBuilder()
    val stack = ArrayList<Char>()
    var pos = 0
    for (c in s) {
        cnt[c - 'a']--
        stack.add(c)
        while (pos != 26 && cnt[pos] == 0)
            pos++
        while (stack.isNotEmpty() && stack.last() - 'a' <= pos)
            ans.append(stack.removeLast())
    }
    return ans.toString()
}
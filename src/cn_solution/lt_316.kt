package cn_solution

fun removeDuplicateLetters(s: String): String {
    val sb = StringBuilder()
    val use = BooleanArray(26)
    val cnt = IntArray(26)
    s.forEach { cnt[it - 'a']++ }
    for (c in s) {
        cnt[c - 'a']--
        if (use[c - 'a'])
            continue
        while (sb.isNotEmpty() && c < sb.last() && cnt[sb.last() - 'a'] != 0) {
            use[sb.last() - 'a'] = false
            sb.deleteAt(sb.lastIndex)
        }
        sb.append(c)
        use[c - 'a'] = true
    }
    return sb.toString()
}
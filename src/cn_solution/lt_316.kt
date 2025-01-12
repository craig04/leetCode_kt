package cn_solution

private fun removeDuplicateLetters(s: String): String {
    val a = ArrayList<Char>()
    val use = BooleanArray(26)
    val cnt = s.groupingBy { it }.eachCountTo(HashMap())
    for (c in s) {
        cnt.merge(c, -1, Int::plus)
        if (use[c - 'a'])
            continue
        while (a.isNotEmpty() && c < a.last() && (cnt[a.last()] ?: 0) != 0)
            use[a.removeLast() - 'a'] = false
        a.add(c)
        use[c - 'a'] = true
    }
    return a.fold(StringBuilder()) { sb, c -> sb.append(c) }.toString()
}
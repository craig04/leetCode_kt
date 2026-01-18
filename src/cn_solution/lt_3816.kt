package cn_solution

fun lexSmallestAfterDeletion(s: String): String {
    val cnt = IntArray(26)
    for (c in s)
        cnt[c - 'a']++
    val sb = CharArray(s.length)
    var top = -1
    for (c in s) {
        while (top >= 0 && sb[top] > c && --cnt[sb[top] - 'a'] > 0)
            --top
        sb[++top] = c
    }
    while (top != 0 && --cnt[sb[top] - 'a'] > 0)
        --top
    return String(sb, 0, top + 1)
}
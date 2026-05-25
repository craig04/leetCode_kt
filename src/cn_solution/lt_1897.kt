package cn_solution

fun makeEqual(words: Array<String>): Boolean {
    val cnt = IntArray(26)
    for (word in words)
        for (c in word)
            cnt[c - 'a']++
    return cnt.all { it % words.size == 0 }
}
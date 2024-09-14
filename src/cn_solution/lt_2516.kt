package cn_solution

fun takeCharacters(s: String, k: Int): Int {
    val cnt = IntArray(3)
    s.forEach { cnt[it - 'a']++ }
    if (cnt.min() < k)
        return -1
    var i = 0
    return s.indices.minOf { j ->
        val c = s[j] - 'a'
        cnt[c]--
        while (cnt[c] < k)
            cnt[s[i++] - 'a']++
        s.length - j - 1 + i
    }
}